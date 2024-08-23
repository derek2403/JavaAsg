package com.charitymanagement.entity;

import com.charitymanagement.adt.LinkedList;

public class Volunteer {
    private String id;
    private String name;
    private LinkedList<Event> events;

    public Volunteer(String id, String name) {
        this.id = id;
        this.name = name;
        this.events = new LinkedList<>();
    }

    // Getters, setters, and other methods
}