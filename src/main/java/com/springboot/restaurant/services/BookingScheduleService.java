package com.springboot.restaurant.services;

import com.springboot.restaurant.models.BookingSchedule;
import com.springboot.restaurant.repostories.BookingScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingScheduleService {
    private BookingScheduleRepository bookingRepository;

    @Autowired
    public BookingScheduleService(BookingScheduleRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public BookingSchedule bookTable(BookingSchedule booking){
        return bookingRepository.save(booking);
    }

    public List<BookingSchedule> getAllReservations(){
        return bookingRepository.findAll();
    }


}
