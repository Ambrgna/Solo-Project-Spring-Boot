package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Dao.RestaurantDeo;
import com.genspark.SpringBootdemoApplication.Entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantDeo restaurantDeo;

    @Override
    public List<Restaurant> getAllRestaurants() {
        return this.restaurantDeo.findAll();
    }
    @Override
    public List<Restaurant> getAllByOwner(int owner) {
        return this.restaurantDeo.findAllByOwner(owner);
    }

    @Override
    public Restaurant getRestaurantById(int restaurantID) {
        Optional <Restaurant> r = this.restaurantDeo.findById(restaurantID);
        Restaurant restaurant = null;
        if (r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException(" Restaurant not found for id :: " + restaurantID);
        }
        return restaurant;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return this.restaurantDeo.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return this.restaurantDeo.save(restaurant);
    }

    @Override
    public String deleteRestaurantById(int restaurantID) {
        Optional <Restaurant> r = this.restaurantDeo.findById(restaurantID);
        Restaurant restaurant = null;
        if (r.isPresent()){
            restaurant = r.get();
        } else {
            throw new RuntimeException(" Restaurant not found for id :: " + restaurantID);
        }
        restaurant.setDisabled(true);
        restaurant.setRemoved_at(new Date());
        this.restaurantDeo.save(restaurant);
//        this.restaurantDeo.deleteById(restaurantID);
        return "Removed Successfully";
    }
}
