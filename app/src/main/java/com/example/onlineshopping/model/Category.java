package com.example.onlineshopping.model;

public class Category {
    Integer id;
    Integer imageuri;

    public Category(Integer id, Integer imageuri) {
        this.id = id;
        this.imageuri = imageuri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getImageuri() {
        return imageuri;
    }

    public void setImageuri(Integer imageuri) {
        this.imageuri = imageuri;
    }
}
