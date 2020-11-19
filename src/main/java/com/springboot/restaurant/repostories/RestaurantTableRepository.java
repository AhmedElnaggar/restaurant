package com.springboot.restaurant.repostories;

import com.springboot.restaurant.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository  extends JpaRepository<RestaurantTable,Long> {
}
