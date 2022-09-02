package com.sbs.foodtruck2.Controller;

import com.sbs.foodtruck2.DTO.OrderDTO;
import com.sbs.foodtruck2.Mapper.TruckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private TruckMapper truckMapper;

    @GetMapping("/order/all")
    public List<OrderDTO> findAllOrder(){
        List<OrderDTO> orders = truckMapper.findAllOrder();

        return orders;
    }


    @GetMapping("/order/{truckId}")
    public List<OrderDTO> findTruckOrder(@PathVariable int truckId){
        List<OrderDTO> orders = truckMapper.findTruckOrder(truckId);

        return orders;
    }

    @PostMapping("/order/add")
    public void insertOrder(@RequestBody OrderDTO orderDTO){
        truckMapper.insertOrder(orderDTO);
    }

}
