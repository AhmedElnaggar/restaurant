package com.springboot.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity(name = "tables")

public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "please enter table number")
    private int tableNumber;
    @NotNull(message = "please enter number of persons")
    private int numberOfPersons;

    @JsonIgnore
    @OneToMany(mappedBy = "table")
    List<BookingSchedule> bookingSchedules;

    public RestaurantTable() {
    }

    public Long getId() {
        return id;
    }



    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public List<BookingSchedule> getBookingSchedules() {
        return bookingSchedules;
    }

    public void setBookingSchedules(List<BookingSchedule> bookingSchedules) {
        this.bookingSchedules = bookingSchedules;
    }
}
