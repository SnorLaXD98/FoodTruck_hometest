package com.sbs.foodtruck2.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TruckDTO {

    private String id;
    private String image;
    //@JsonIgnore
    private LocationDTO location;
    private String latitude;
    private String longitude;
    private String name;
    private String open_date;
    private String order_count;
    private String rate;
    private String title;
    private String type;
    private double distance;
    private String wait_time;



    public TruckDTO(){
    }

    public TruckDTO(String id, String image, LocationDTO location, String latitude, String longitude, String name, String open_date, String order_count, String rate, String title, String type, double distance, String wait_time) {
        this.id = id;
        this.image = image;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.open_date = open_date;
        this.order_count = order_count;
        this.rate = rate;
        this.title = title;
        this.type = type;
        this.distance = distance;
        this.wait_time = wait_time;
    }

    @Override
    public String toString() {
        return "TruckDTO{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", location=" + location +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                ", open_date='" + open_date + '\'' +
                ", order_count='" + order_count + '\'' +
                ", rate='" + rate + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", distance=" + distance +
                ", wait_time='" + wait_time + '\'' +
                '}';
    }

    public void seperateLoca(){
        this.latitude = this.location.getLatitude();
        this.longitude = this.location.getLongitude();

    }
}
