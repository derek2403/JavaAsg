package com.charitymanagement.control;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.entity.Event;
import com.charitymanagement.entity.Volunteer;

public class EventManagement {
    private LinkedList<Event> events;

    public EventManagement() {
        events = new LinkedList<>();
    }

    // Add a new event
    public void addEvent(Event event) {
        events.add(event);
    }

    // Remove an event
    public boolean removeEvent(String eventId) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(eventId)) {
                events.remove(events.get(i));
                return true;
            }
        }
        return false;
    }

    // Update event details
    public boolean updateEventDetails(String eventId, String name, String date) {
        Event event = findEventById(eventId);
        if (event != null) {
            event.setName(name);
            event.setDate(date);
            return true;
        }
        return false;
    }

    // Search event details
    public Event findEventById(String eventId) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(eventId)) {
                return events.get(i);
            }
        }
        return null;
    }

    // List all events
    public void listAllEvents() {
        for (int i = 0; i < events.size(); i++) {
            System.out.println(events.get(i));
        }
    }

    // Filter events based on criteria (this can be expanded as needed)
    public LinkedList<Event> filterEvents(String criteria) {
        LinkedList<Event> filteredEvents = new LinkedList<>();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getName().toLowerCase().contains(criteria.toLowerCase())) {
                filteredEvents.add(events.get(i));
            }
        }
        return filteredEvents;
    }

    // Generate summary report
    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder("Event Summary Report\n");
        report.append("Total number of events: ").append(events.size()).append("\n");
        // Add more summary information as needed
        return report.toString();
    }

    // Get all events
    public LinkedList<Event> getAllEvents() {
        return events;
    }

    public boolean removeEventFromVolunteer(String eventId, Volunteer volunteer) {
        Event event = findEventById(eventId);
        if (event != null && volunteer != null) {
            return volunteer.removeEvent(event);
        }
        return false;
    }

    public LinkedList<Event> getEventsForVolunteer(Volunteer volunteer) {
        return volunteer != null ? volunteer.getEvents() : new LinkedList<>();
    }
}
