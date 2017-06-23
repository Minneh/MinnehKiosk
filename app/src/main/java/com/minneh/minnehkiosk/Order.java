package com.minneh.minnehkiosk;

/**
 * Created by minnehmugo on 22/06/2017.
 */

public class Order {
    String name;
    String quantity;
    String price;
    String cost;

    public Order() {}

    public Order(String name, String quantity, String price, String cost) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.cost = cost;
    }
    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getCost() {
        return cost;
    }

}
