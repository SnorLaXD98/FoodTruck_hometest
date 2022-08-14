package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class UserAccountDTO {

    private String idToken; // firebase 고유아이디 key값
    private String email; // 아이디
    private String password; // 패스워드
    private String name; // 이름
    private String phoneNumber;
    private ArrayList<FavoriteDTO> favorites;

    public UserAccountDTO(){

    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<FavoriteDTO> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<FavoriteDTO> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "UserAccountDTO{" +
                "idToken='" + idToken + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", favorites=" + favorites +
                '}';
    }

}
