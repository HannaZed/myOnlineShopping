package com.example.onlineshopping.model;

public class RecentlyViewed {
    String name;
    String description;
    String unit;
    String quality;
    Integer imageUri;
    String price;

    public RecentlyViewed(String name, String description, String unit, String quality, Integer imageUri, String price) {
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.quality = quality;
        this.imageUri = imageUri;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getImageUri() {
        return imageUri;
    }

    public void setImageUri(Integer imageUri) {
        this.imageUri = imageUri;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
