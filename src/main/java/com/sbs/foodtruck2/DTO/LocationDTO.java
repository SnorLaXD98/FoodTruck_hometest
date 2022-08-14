package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.xml.stream.Location;

@Getter
@Setter
public class LocationDTO {

    private String latitude;
    private String longitude;

    public LocationDTO(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationDTO(){

    }

    @Override
    public String toString() {
        return "LocationDTO{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }


}
