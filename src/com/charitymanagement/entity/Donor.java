package com.charitymanagement.entity;

import com.charitymanagement.adt.LinkedList;

public class Donor {
    private String id;
    private String name;
    private String type;
    private LinkedList<Donation> donations;

    public Donor(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.donations = new LinkedList<>();
    }

    // Getters, setters, and other methods
}