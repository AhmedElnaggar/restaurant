package com.springboot.restaurant.controllers;

import com.springboot.restaurant.models.BookingSchedule;
import com.springboot.restaurant.services.BookingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingScheduleController {
    private BookingScheduleService bookingService;

    @Autowired
    public BookingScheduleController(BookingScheduleService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/booktable")
    public BookingSchedule bookTable(@RequestBody BookingSchedule booking){
        return bookingService.bookTable(booking);
    }

    @GetMapping("/allreservation")
    public List<BookingSchedule> getAllReservations(){
        return bookingService.getAllReservations();
    }
}
