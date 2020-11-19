package com.springboot.restaurant.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "name can not be empty")
    @Size(min = 3 , message = "name length must be at least 3 letters")
    private String name;
    @NotNull(message = "password can not be empty")
    @Size(min = 8 , message = "password length must be at least 8")
    private String password;

    @NotNull(message = "please enter a valid phone number")
    @Column(unique = true , length = 11)
    private String phone;

    @NotNull(message = "please enter a valid email")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<BookingSchedule> myReservation;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BookingSchedule> getMyReservation() {
        return myReservation;
    }

    public void setMyReservation(List<BookingSchedule> myReservation) {
        this.myReservation = myReservation;
    }
}
