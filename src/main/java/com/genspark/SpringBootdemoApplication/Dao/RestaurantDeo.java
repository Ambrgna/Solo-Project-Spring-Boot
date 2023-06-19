package com.genspark.SpringBootdemoApplication.Dao;


import com.genspark.SpringBootdemoApplication.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDeo extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findAllByOwner(int id);
}
