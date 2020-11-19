package com.springboot.restaurant.services;

import com.springboot.restaurant.models.RestaurantTable;
import com.springboot.restaurant.repostories.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableService {
    private RestaurantTableRepository tableRepository;

    @Autowired
    public RestaurantTableService(RestaurantTableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public RestaurantTable addTable(RestaurantTable table){
         RestaurantTable tab=tableRepository.save(table);
         return tab;
    }

}
