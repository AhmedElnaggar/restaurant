package com.springboot.restaurant.repostories;

import com.springboot.restaurant.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email,String password);

}
