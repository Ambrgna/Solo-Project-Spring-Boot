package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    List<Restaurant> getAllByOwner(int restaurantID);

    Restaurant getRestaurantById(int restaurantID);
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    String deleteRestaurantById(int restaurantID);
}
