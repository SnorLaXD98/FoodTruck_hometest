
package com.sbs.foodtruck2.Controller;

import com.sbs.foodtruck2.DTO.TruckDTO;
import com.sbs.foodtruck2.DTO.UserAccountDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserAccountController {


    @Autowired
    private TruckMapper truckMapper;

    @GetMapping("/user/search/all")
    public List<UserAccountDTO> findUserAccountAll(){
        List<UserAccountDTO> users = truckMapper.findUserAll();
        return users;
    }

    @PostMapping("/user/add")
    public void insertUserAccount(@RequestBody UserAccountDTO userAccountDTO){
        truckMapper.insertUserAccount(userAccountDTO);
    }
    @GetMapping("/user/search/{email}")
    public UserAccountDTO findUserAccount(@PathVariable String email){
        UserAccountDTO user = truckMapper.findUserAccount(email);
        return  user;
    }

    @DeleteMapping("/user/delete/{idToken}")
    public void deleteUserAccount(@PathVariable String idToken) {
        truckMapper.deleteUserAccount(idToken);
        System.out.println("UserAccount idToken = " + idToken +"이 삭제되었습니다.");
    }


    @PatchMapping("/user/modify/password/{changed_password}")
    public void modifyPwUserAccount(@PathVariable String changed_password, @RequestBody UserAccountDTO userAccountDTO) {

        HashMap<String, Object> hashMap = new HashMap<String, Object>();


         UserAccountDTO u1 = truckMapper.findUserAccount(userAccountDTO.getEmail());
        if (u1.getIdToken().equals(userAccountDTO.getIdToken())) {
            System.out.println("success");
            hashMap.put("changed_password", changed_password);
            hashMap.put("email", userAccountDTO.getEmail());
            hashMap.put("idToken", userAccountDTO.getIdToken());
            truckMapper.modifyPwUserAccount(hashMap);
        }else{ System.out.println("fail");}

    }

    @PatchMapping("/user/modify/name/{changed_name}")
    public void modifyNameUserAccount(@PathVariable String changed_name, @RequestBody UserAccountDTO userAccountDTO) {

        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        UserAccountDTO u1 = truckMapper.findUserAccount(userAccountDTO.getEmail());
        if (u1.getIdToken().equals(userAccountDTO.getIdToken())) {
            System.out.println("success");
            hashMap.put("changed_name", changed_name);
            hashMap.put("email", userAccountDTO.getEmail());
            hashMap.put("idToken", userAccountDTO.getIdToken());
            truckMapper.modifyNameUserAccount(hashMap);
        }else{ System.out.println("fail");}

    }

}
