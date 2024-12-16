package com.example.proyekmpevan;

public class ItemModel {
    private String name;
    private String price;

    public ItemModel(String inputName, String inputPrice){
        name = inputName;
        price = inputPrice;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
