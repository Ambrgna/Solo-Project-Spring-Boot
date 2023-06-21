package com.genspark.SpringBootdemoApplication.Service;

import com.genspark.SpringBootdemoApplication.Dao.ItemDeo;
import com.genspark.SpringBootdemoApplication.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDeo itemDeo;

    @Override
    public List<Item> getAllItems() {
        return this.itemDeo.findAll();
    }
    @Override
    public List<Item> findAllByRestaurantId(int restaurantID) {
        return this.itemDeo.findAllByRestaurantId(restaurantID);
    }
    @Override
    public Item getItemById(int itemID) {
        Optional <Item> i = this.itemDeo.findById(itemID);
        Item item = null;
        if (i.isPresent()){
            item = i.get();
        } else {
            throw new RuntimeException(" Item not found for id :: " + itemID);
        }
        return item;
    }

    @Override
    public Item addItem(Item item) {
        return this.itemDeo.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return this.itemDeo.save(item);
    }

    @Override
    public String deleteItemById(int itemID) {
        Optional <Item> i = this.itemDeo.findById(itemID);
        Item item = null;
        if (i.isPresent()){
            item = i.get();
        } else {
            throw new RuntimeException(" Item not found for id :: " + itemID);
        }
        item.setDisabled(true);
        item.setRemoved_at(new Date());
        this.itemDeo.save(item);
        return "Removed Successfully";
    }
}
