package com.genspark.SpringBootdemoApplication.Controller;

import com.genspark.SpringBootdemoApplication.Entity.Item;
import com.genspark.SpringBootdemoApplication.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/{restaurantID}/items")
    public List<Item> getItemsByID(@PathVariable String restaurantID){
        return this.itemService.findAllByRestaurantId(Integer.parseInt(restaurantID));
    }
    @GetMapping("/items/{itemID}")
    public Item getItem(@PathVariable String itemID){
        return this.itemService.getItemById(Integer.parseInt(itemID));
    }
    @PostMapping("/items")
    public Item addItem(@RequestBody Item item){
        return this.itemService.addItem(item);
    }
    @PutMapping("/items")
    public Item updateItem(@RequestBody Item item){
        return this.itemService.updateItem(item);
    }
    @DeleteMapping("/items/{itemID}")
    public String deleteItem(@PathVariable String itemID){
        return this.itemService.deleteItemById(Integer.parseInt(itemID));
    }
}
