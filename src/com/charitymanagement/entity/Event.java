package com.charitymanagement.entity;

import com.charitymanagement.adt.LinkedList;

public class Event {
    private String id;
    private String name;
    private String date;
    private LinkedList<Volunteer> volunteers;

    public Event(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.volunteers = new LinkedList<>();
    }

    // Getters, setters, and other methods
}
