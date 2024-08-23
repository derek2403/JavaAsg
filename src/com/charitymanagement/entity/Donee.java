package com.charitymanagement.entity;

import com.charitymanagement.adt.LinkedList;

public class Donee {
    private String id;
    private String name;
    private String type;
    private LinkedList<Donation> receivedDonations;

    public Donee(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.receivedDonations = new LinkedList<>();
    }

    // Getters, setters, and other methods
}
