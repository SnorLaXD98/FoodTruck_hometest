package com.sbs.foodtruck2.Configuration;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    /*
     * HikariCP 설정 1
     *
     * @Bean : return되는 객체를 IoC 컨테이너에 등록.
     * 특별히 지정하는 이름이 없다면 IoC컨테이너에 해당하는 메서드 명으로 등록, 물론 이름지정도 가능 . 보통은 메서드명으로 등록. 중복X
     * applivation.properties 파이로 부터 데이터베이스 관련된 정보를 읽어와서  히카리 설정 객체를 리턴.
     * 접두어는 해당 접두어로 시작하는 정보들을 읽어온다는 뜻임.
     * */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {

        return new HikariConfig();
    }

    /*
     * HikariCP 설정 2
     *
     * 히카리 설정객체 (HikariConfig)를 넘겨받아서 DataSource객체를 리턴.
     * 이 단계에서 데이터베이스 연결이 완성.
     * 만약 아이디나 패스워드가 틀렸다면 당연히 이단계에서 오류 발생. 다시금 application.properties파일체크.
     * DB연결이 잘되었는지 확인해보기 위해서 콘솔이 DataSource 객체를 toString() 매서드로 출력
     * 히카리 뒤에 숫자가 붙어나옴 ---> HikariDataSource(HikariPool-1)
     * 이 단계를 통해서 히카리CP(ConnectionPool) 연결이 완성.
     * 이제 DB 연결이 필요한 부분에서 이 dataSource를 가지고 연결해주면 됨.
     * */
    @Bean
    public DataSource dataSource() {

        DataSource dataSource = new HikariDataSource(hikariConfig());
        System.out.println(dataSource.toString()); //hikaripool-1출력 확인


        return dataSource;
    }

    /*MyBatis 설정 1 : SqlSessionFactory <-- SqlSessionFactoryBean
     *
     * SqlSessionFactory 객체 생성
     *  SqlSessionFactory 생성을 위해서 내부의 SqlSessionFactoryBean을 사용.
     * 이때, 데이터 소스 객체를 넘겨 받아서 처리해도 되고 아니면 setDataSource(dataSource())이렇게 해도 됨.
     *
     *  기본적인 설정 3가지
     *  		setDataSource 			:	빌드된 DataSource를 셋팅
     *  		setMapperLocation		:	SQL구문이 작성된 Mapper.xml의 경로를 정확히 등록.
     *  		setTypeAliasesPackage	:	인자로 Alias 대상 클래스가 위치한 패키지 경로.
     *
     *  주의사항!
     *  SqlSessionFactory에 저장할 config 설정시 Mapper에서 사용하고자하는 DTO, VO,Entity에 대해서 setTypeAliasesPackage 지정 필요.
     *  만약 지정해주지 않는다면 aliases 찾지못한다는 오류가 발생할 수 있음.
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean =new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/Mapper/**.xml"));//resources 폴더 가 클래스 패스
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/Mapper/*Mapper.xml"));

        /*
         * 매퍼에 대한 리소스는 어디에서 가져오지??
         * 				- ApplicationContext 객체에서 가져올 수 있다.
         * 				- ApplicationContext 는 쉽게말해 프레임워크 컨테이너라고 생각하면됨.
         * 				- ApplicationContext는 애플리케이션의 스타트 해서 끝나는 그 순간까지 이 애플리케이션에서 필요한 모든 자원들을 모아놓고 관리.
         * */
        factoryBean.setTypeAliasesPackage("com.sbs.foodtruck2.DTO");




        return factoryBean.getObject();
    }

    /*
     * MyBatis 설정 2
     *
     * SqlSessionTemplate 객체 생성<-- SqlSessionFactory
     * 넘겨받은 sqlSessionFactory를 통해서 sqlSessionTemplate 객체를 생성 및 리턴.
     * SQL구문과 실행과 트랙잭션 등을 관리하는 가장 열일하는 애.
     * MYbatis의 sqlSession 객체가 Sprint+MyBatis 연동모듈에서는 sqlSessionTemplate이 대체
     *
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {

        return new SqlSessionTemplate(sqlSessionFactory);
    }



}