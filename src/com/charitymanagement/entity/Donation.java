package com.charitymanagement.entity;

public class Donation {
    private String id;
    private String donorId;
    private String doneeId;
    private double amount;
    private String description;

    public Donation(String id, String donorId, String doneeId, double amount, String description) {
        this.id = id;
        this.donorId = donorId;
        this.doneeId = doneeId;
        this.amount = amount;
        this.description = description;
    }

    // Getters, setters, and other methods
}
