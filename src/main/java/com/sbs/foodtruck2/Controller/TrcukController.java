package com.sbs.foodtruck2.Controller;

import com.sbs.foodtruck2.DTO.FoodDTO;
import com.sbs.foodtruck2.DTO.LocationDTO;
import com.sbs.foodtruck2.DTO.TruckDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrcukController {
    private void locationSetting(List<TruckDTO> trucks){
        for(int i = 0;i<trucks.size();i++)
        {
            String Latitude = trucks.get(i).getLatitude();
            String Longitude = trucks.get(i).getLongitude();
            LocationDTO locationDTO = new LocationDTO( Latitude,Longitude);
            trucks.get(i).setLocation(locationDTO);
        }
    }

    @Autowired
    private TruckMapper truckMapper;

    //모든 트럭 찾기
    @GetMapping("/truck/all")
    public List<TruckDTO> truckForm() {
        List<TruckDTO> trucks = truckMapper.findAll();
        locationSetting(trucks);

        return trucks;
    }
    @GetMapping("/truck/search/{type}")
    public List<TruckDTO> SearchTruck(@PathVariable String type){
        List<TruckDTO> trucks = truckMapper.findFoodTruck(type);
        locationSetting(trucks);

        return trucks;
    }

    @GetMapping("/truck/search/rate")
    public List<TruckDTO> SearchRateTruck(){
        List<TruckDTO> trucks =truckMapper.SearchRateTruck();
        return trucks;
    }

    //음식 종류별 거리정렬
    @GetMapping("/truck/search/distance/{type}")
    public List<TruckDTO> SearchTrcukDistance(@PathVariable String type) {
        List<TruckDTO> trucks = truckMapper.distanceFoodTruck(type);
        locationSetting(trucks);
        return trucks;
    }
    //음식 종류별 rate정렬
    @GetMapping("/truck/search/rate/{type}")
    public List<TruckDTO> SearchTrcukRate(@PathVariable String type) {
        List<TruckDTO> trucks = truckMapper.rateFoodTruck(type);
        locationSetting(trucks);

        return trucks;
    }

    @PostMapping("/truck/add")
    public String insertTruck(@RequestBody TruckDTO truck){
            truck.seperateLoca();
            truckMapper.insertFoodTruck(truck);
            return truck.toString();
    }

    @GetMapping("/truck/search/opentime")
    public List<TruckDTO> searchTruckTime(){
        List<TruckDTO> trucks =  truckMapper.openTimeTruck();
        locationSetting(trucks);
        return trucks;
    }

    @DeleteMapping("/truck/delete/{id}")
    public void deleteTruck(@PathVariable String id){
            truckMapper.deleteTruck(id);
    }





}