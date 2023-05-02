package com.example.selenkhoury;

public class FoodTModel {
    String foodName;
    int image;

    public FoodTModel(String foodName , int image) {
        this.foodName = foodName;
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getImage() {
        return image;
    }



}
