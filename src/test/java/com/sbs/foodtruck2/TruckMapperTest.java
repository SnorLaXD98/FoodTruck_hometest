package com.sbs.foodtruck2;

import com.sbs.foodtruck2.DTO.LocationDTO;
import com.sbs.foodtruck2.DTO.NoticeDTO;
import com.sbs.foodtruck2.DTO.TruckDTO;
import com.sbs.foodtruck2.DTO.UserAccountDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TruckMapperTest {

    @Autowired
    private TruckMapper truckMapper;

    @Test
    public void testInsert(){
/*
        TruckDTO t1 = new TruckDTO();
        List<TruckDTO> lt1;
        List<TruckDTO> lt2;


        t1.setId("1212");
        t1.setImage("image.url");
        t1.setName("햄버거");
        t1.setOpen_data("22/6/1");
        t1.setOrder_count("1");
        t1.setRate("5");
        t1.setDistance(12);
        t1.setType("양식");
        t1.setTitle("맛있는 햄버거집");
        t1.setLocation(new LocationDTO( "135","125"));
        t1.SeperateLoca(t1);


       lt1 = truckMapper.distanceFoodTruck("양식");
       lt2 = truckMapper.rateFoodTruck("양식");

       System.out.println(t1.toString());
       System.out.println(lt1);
       System.out.println(lt2);

// 유저테스트
        UserAccountDTO u1 = new UserAccountDTO();

        u1.setEmail("gkgk0713@naver.com");
        u1.setName("진정현");
        u1.setPassword("1234");
        u1.setIdToken("123456789");

        System.out.println(u1.toString());

        truckMapper.insertUserAccount(u1);

            // 공지사항 테스트
        NoticeDTO n1 = new NoticeDTO();
        
        n1.setContent("또또또 다시한번 테스트 중입니다.");
        n1.setTitle("또또또 다시 테스트 제목");

        truckMapper.insertNotice(n1);

        List<TruckDTO> trucks =  truckMapper.openTimeTruck();
        for(int i = 0;i<trucks.size();i++)
        {
            String Latitude = trucks.get(i).getLatitude();
            String Longitude = trucks.get(i).getLongitude();
            LocationDTO locationDTO = new LocationDTO( Latitude,Longitude);
            trucks.get(i).setLocation(locationDTO);
        }
*/

        UserAccountDTO u1 = new UserAccountDTO();

        u1 = truckMapper.findUserAccount("testing@test.com");
        String asdf = "check";
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("email",u1.getEmail());
        hashMap.put("idToken",u1.getIdToken());
        hashMap.put("changed_password", asdf);

        System.out.println(u1);
        truckMapper.modifyPwUserAccount(hashMap);

    }

}
