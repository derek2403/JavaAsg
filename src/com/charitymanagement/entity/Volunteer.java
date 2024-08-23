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

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void addEvent(Event event) {
        events.add(event);
    }

    public boolean removeEvent(Event event) {
        return events.remove(event);
    }

    public LinkedList<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return "Volunteer{id='" + id + "', name='" + name + "', events=" + events.size() + "}";
    }
}