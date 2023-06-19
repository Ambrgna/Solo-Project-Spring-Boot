package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Restaurant;
import com.genspark.SpringBootdemoApplication.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping
    public List<Restaurant> getRestaurants(){
        return this.restaurantService.getAllRestaurants();
    }
    @GetMapping("/owner/{ownerID}")
    public List<Restaurant> getRestaurantsByOwner(@PathVariable String ownerID){
        return this.restaurantService.getAllByOwner(Integer.parseInt(ownerID));
    }
    @GetMapping("/{restaurantID}")
    public Restaurant getRestaurant(@PathVariable String restaurantID){
        return this.restaurantService.getRestaurantById(Integer.parseInt(restaurantID));
    }
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return this.restaurantService.addRestaurant(restaurant);
    }
    @PutMapping
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant){
        return this.restaurantService.updateRestaurant(restaurant);
    }
    @DeleteMapping("/{restaurantID}")
    public String deleteRestaurant(@PathVariable String restaurantID){
        return this.restaurantService.deleteRestaurantById(Integer.parseInt(restaurantID));
    }
}
