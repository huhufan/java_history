package com.imooc.utils;

public class Food {
    private String id, foodName, taste, foodImage, description;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Food(String id, String foodName, String taste, String foodImage, double price, String description) {
        this.id = id;
        this.foodName = foodName;
        this.taste = taste;
        this.foodImage = foodImage;
        this.price = price;
        this.description = description;
    }
}