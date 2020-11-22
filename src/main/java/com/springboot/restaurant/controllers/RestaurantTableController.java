package com.springboot.restaurant.controllers;

import com.springboot.restaurant.models.AvailableTableRequest;
import com.springboot.restaurant.models.BookingSchedule;
import com.springboot.restaurant.models.RestaurantTable;
import com.springboot.restaurant.services.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/allTables")
     public List<RestaurantTable> viewAllTables(){
        return tableService.gelAllTables();
     }

    @PostMapping("/availabletables")
    public List<RestaurantTable> getAvailableTables(@RequestBody AvailableTableRequest tableRequest){

        List<RestaurantTable> availableTables=tableService.gelAllTables().stream().filter(table -> {
             // get table reservation
             // check if reservation not in the search reservation date and time

             List<BookingSchedule> list = table.getBookingSchedules().stream().filter(bookingSchedule -> {
                         System.out.println(bookingSchedule.getBookingKey().getFromDate());
                 System.out.println(tableRequest.getFromDate());
                         System.out.println(bookingSchedule.getBookingKey().getToDate());
                 System.out.println(tableRequest.getToDate());
                         return (bookingSchedule.getBookingKey().getFromDate().equals(tableRequest.getFromDate()))
                                 &&
                                 (bookingSchedule.getBookingKey().getToDate().equals(tableRequest.getToDate()));
                     }
             ).collect(Collectors.toList());
             if(list.size() > 0) return false;
             return true;
         }).collect(Collectors.toList());
        return availableTables;
    }

}
