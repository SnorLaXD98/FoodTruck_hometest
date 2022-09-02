package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDTO {

    private String truckID;
    private String food_name;
    private String food_cost;
    private int food_number;

    public OrderDTO(){

    }

    public OrderDTO(String truckID, String food_name, String food_cost, int food_number) {
        this.truckID = truckID;
        this.food_name = food_name;
        this.food_cost = food_cost;
        this.food_number = food_number;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "truckID='" + truckID + '\'' +
                ", food_name='" + food_name + '\'' +
                ", food_cost='" + food_cost + '\'' +
                ", food_number=" + food_number +
                '}';
    }
}
