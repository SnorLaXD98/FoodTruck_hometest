package com.sbs.foodtruck2.Mapper;

import com.sbs.foodtruck2.DTO.FoodDTO;
import com.sbs.foodtruck2.DTO.NoticeDTO;
import com.sbs.foodtruck2.DTO.TruckDTO;
import com.sbs.foodtruck2.DTO.UserAccountDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface TruckMapper {

    public void insertFoodTruck(TruckDTO truckDTO);

    @Select("Select * from truck")
    List<TruckDTO> findAll();

    // 음식 종류별로 검색하기.
    public List<TruckDTO> findFoodTruck(String type);

    // 음식종류별 거리별 정렬하기
    public List<TruckDTO> distanceFoodTruck(String type);

    //음식 종류별 점수 정렬 하기
    public List<TruckDTO> rateFoodTruck(String type);

    //트럭 오픈 시간 정렬
    public List<TruckDTO> openTimeTruck();
    //트럭 삭제
    public void deleteTruck(String id);

    //인기트럭 검색
    public List<TruckDTO>SearchRateTruck();




    /*     ------------------userAccount------------------*/
    public void insertUserAccount(UserAccountDTO userAccountDTO);

    @Select("Select * from UserAccount")
    public List<UserAccountDTO> findUserAll();

    public UserAccountDTO findUserAccount(String email);

    public void deleteUserAccount(String idToken);

    public void modifyPwUserAccount(HashMap<String,Object> hashMap);

    public void modifyNameUserAccount(HashMap<String,Object> hashMap);


    /* --------------------Notice---------------------*/
    //공지사항 불러오기
    @Select("Select * from Notice")
    public List<NoticeDTO> findAllNotice();

    //공지사항 등록
    public void insertNotice(NoticeDTO noticeDTO);

    //공지사항 정렬
    public List<NoticeDTO> sortNotice();

    public void deleteNotice(int id);

    public NoticeDTO searchNotice(int NoticeId);

    public void modifyNotice(NoticeDTO noticeDTO);

    /* --------------------Food---------------------*/
    @Select("Select * from food")
    public List<FoodDTO> findAllFood();

   public List<FoodDTO> findTruckFood(int truckId);


}
