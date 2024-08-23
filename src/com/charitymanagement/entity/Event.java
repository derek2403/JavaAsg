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

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean removeVolunteer(Volunteer volunteer) {
        return volunteers.remove(volunteer);
    }

    public LinkedList<Volunteer> getVolunteers() {
        return volunteers;
    }

    @Override
    public String toString() {
        return "Event{id='" + id + "', name='" + name + "', date='" + date + "', volunteers=" + volunteers.size() + "}";
    }
}