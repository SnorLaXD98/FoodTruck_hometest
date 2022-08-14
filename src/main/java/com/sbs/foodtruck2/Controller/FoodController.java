package com.sbs.foodtruck2.Controller;

import com.sbs.foodtruck2.DTO.FoodDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {


    @Autowired
    private TruckMapper truckMapper;

    @GetMapping("/food/all")
    public List<FoodDTO> getAllfood(){
        List<FoodDTO> foods = truckMapper.findAllFood();
        return foods;
    }

    @GetMapping("food/truck/{truckId}")
    public List<FoodDTO> getTruckFood(@PathVariable int truckId){
        List<FoodDTO> foods = truckMapper.findTruckFood(truckId);
        return foods;
    }
}
