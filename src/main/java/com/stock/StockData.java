package com.stock;

public class StockData {
    private int day;
    private int price;

    public StockData(int day, int price) {
        this.day = day;
        this.price = price;
    }

    public int getDay() {
        return day;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Day " + day + ": ₹" + price;
    }
}