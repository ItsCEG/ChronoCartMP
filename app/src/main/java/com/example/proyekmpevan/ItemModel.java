package com.example.proyekmpevan;

public class ItemModel {
    private String name;
    private double price;

    public ItemModel(String inputName, double inputPrice){
        name = inputName;
        price = inputPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
