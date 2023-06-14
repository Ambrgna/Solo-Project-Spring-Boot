package com.genspark.SpringBootdemoApplication.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tbl_items")
public class Item {
    @Id
    @Column(name="i_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    @Column(nullable = false)
    private int restaurantId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int price;
    private boolean disabled = false;
    @Column(updatable = false)
    private Date created_at = new Date();
    private Date removed_at;

    public Item() {
    }

    public Item(int itemId, int restaurantId, String name, int price, boolean disabled, Date created_at, Date removed_at) {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.disabled = disabled;
        this.created_at = created_at;
        this.removed_at = removed_at;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getRemoved_at() {
        return removed_at;
    }

    public void setRemoved_at(Date removed_at) {
        this.removed_at = removed_at;
    }
}
