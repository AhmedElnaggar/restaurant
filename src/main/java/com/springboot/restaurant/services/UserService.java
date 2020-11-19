package com.springboot.restaurant.services;

import com.springboot.restaurant.models.RestaurantTable;
import com.springboot.restaurant.models.User;
import com.springboot.restaurant.repostories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User register(User user){
        return userRepository.save(user);

    }

    public User logIn(User user){
        User userFromDb= userRepository.findUserByEmailAndPassword(user.getEmail() ,user.getPassword());
        if (userFromDb ==null){
            throw new NoSuchElementException();
        }
        return userFromDb;
    }

}
