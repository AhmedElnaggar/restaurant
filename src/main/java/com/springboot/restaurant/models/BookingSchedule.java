package com.springboot.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "BOOKING_SCHEDULE")
public class BookingSchedule {
    @EmbeddedId
    private BookingKey bookingKey;

    @JsonIgnore
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "USER_ID" )
    private User user;

    @JsonIgnore
    @ManyToOne
    @MapsId("restaurantTableId")
    @JoinColumn(name = "TABLE_ID" )
    private RestaurantTable table;


    public BookingSchedule() {
    }

    public BookingSchedule(User user, RestaurantTable restaurantTable, BookingKey bookingKey) {

        this.user = user;
        this.table = restaurantTable;
        this.bookingKey = bookingKey;
    }

    public BookingKey getBookingKey() {
        return bookingKey;
    }

    public void setBookingKey(BookingKey bookingKey) {
        this.bookingKey = bookingKey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }
}
