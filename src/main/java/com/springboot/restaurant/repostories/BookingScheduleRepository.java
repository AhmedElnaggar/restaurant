package com.springboot.restaurant.repostories;

import com.springboot.restaurant.models.BookingKey;
import com.springboot.restaurant.models.BookingSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingScheduleRepository extends JpaRepository<BookingSchedule , BookingKey> {
}
