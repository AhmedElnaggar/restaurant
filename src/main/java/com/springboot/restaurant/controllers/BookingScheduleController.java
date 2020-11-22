package com.springboot.restaurant.controllers;

import com.springboot.restaurant.models.BookingKey;
import com.springboot.restaurant.models.BookingSchedule;
import com.springboot.restaurant.models.RestaurantTable;
import com.springboot.restaurant.models.User;
import com.springboot.restaurant.repostories.RestaurantTableRepository;
import com.springboot.restaurant.repostories.UserRepository;
import com.springboot.restaurant.services.BookingScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingScheduleController {
    private BookingScheduleService bookingService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;
    @Autowired
    public BookingScheduleController(BookingScheduleService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/booktable")
        public BookingSchedule bookTable(@RequestBody BookingKey bookingKey)
    {
        User user = userRepository.findById(bookingKey.getUserId()).get();
        RestaurantTable restaurantTable = restaurantTableRepository.findById(bookingKey.getRestaurantTableId()).get();
        BookingSchedule bookingSchedule = new BookingSchedule(user, restaurantTable, bookingKey);

        return bookingService.bookTable(bookingSchedule);

    }

    @GetMapping("/allreservation")
    public List<BookingSchedule> getAllReservations(){
        return bookingService.getAllReservations();
    }
}
