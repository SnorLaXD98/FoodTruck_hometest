package com.sbs.foodtruck2.Controller;

import com.sbs.foodtruck2.DTO.FavoriteDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private TruckMapper truckMapper;

    @GetMapping("/favorite/all")
    public List<FavoriteDTO> findAllFavor() {
        List<FavoriteDTO> favorites = truckMapper.findAllFavor();

        return favorites;
    }

    @GetMapping("/favorite/{userId}")
    public List<FavoriteDTO> findUserFavor(@PathVariable int userId){
        List<FavoriteDTO> favorites = truckMapper.findUserFavor(userId);


        return favorites;
    }

    @PostMapping("/favorite/add")
    public void insertFavorite(@RequestBody FavoriteDTO favoriteDTO){
        truckMapper.insertFavorite(favoriteDTO);
    }

}
