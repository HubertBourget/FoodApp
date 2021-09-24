package com.example.myrestaurant;

import org.parceler.Parcel;

@Parcel
public class FoodItem {
    public FoodItem() {
    }

    private String name;
    private String quantity;
    private String price;
    private String total;

    public FoodItem(String name, String quantity, String price, String total) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
