package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Entity.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();
    List<Item> findAllByRestaurantId(int restaurantID);
    Item getItemById(int restaurantID);
    Item addItem(Item restaurant);
    Item updateItem(Item restaurant);
    String deleteItemById(int restaurantID);
}
