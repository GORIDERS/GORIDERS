package com.example.goapp;


public class RecycleClass {
    int image;
    String text;
    String price;

    public RecycleClass(int image, String text,String price)
    {
        this.image=image;
        this.text=text;
        this.price=price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}