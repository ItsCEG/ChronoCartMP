package com.example.proyekmpevan;

import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart(){
    }

    public Cart(List<Item> items){
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
}
