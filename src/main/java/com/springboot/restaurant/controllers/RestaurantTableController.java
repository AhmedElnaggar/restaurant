package com.springboot.restaurant.controllers;

import com.springboot.restaurant.models.RestaurantTable;
import com.springboot.restaurant.services.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tables")
public class RestaurantTableController {
    private RestaurantTableService tableService;

    @Autowired
    public RestaurantTableController(RestaurantTableService tableService) {
        this.tableService = tableService;
    }

    @PostMapping("/addtable")
    public RestaurantTable addTable(@Valid @RequestBody RestaurantTable table){

        return tableService.addTable(table);
    }

    @GetMapping("/availabletables")
    public String getAvailableTables(){
        return "all tables are available";
    }

}
