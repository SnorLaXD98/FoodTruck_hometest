package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDTO {

    private  int truckId;
    private String cost;
    private String name;
    private  String image;
    private String content;


    public FoodDTO(){

    }

    public FoodDTO(int truckId, String cost, String name, String image, String content) {
        this.truckId = truckId;
        this.cost = cost;
        this.name = name;
        this.image = image;
        this.content = content;
    }

}
