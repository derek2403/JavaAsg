package com.charitymanagement.entity;

public class Donation {
    private String item;
    private double amount;

    public Donation(String item, double amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "item='" + item + '\'' +
                ", amount=" + amount +
                '}';
    }
}
