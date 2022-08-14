package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteDTO {


    private String userId;
    private String truckName;
    private String truckId;

    public FavoriteDTO() {
    }

    public FavoriteDTO(String userId, String truckName, String truckId) {
        this.userId = userId;
        this.truckName = truckName;
        this.truckId = truckId;
    }

}
