package com.charitymanagement.control;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.entity.Event;
import com.charitymanagement.entity.Volunteer;

public class VolunteerManagement {
    private LinkedList<Volunteer> volunteers;

    public VolunteerManagement() {
        volunteers = new LinkedList<>();
    }

    public void addVolunteer(Volunteer volunteer) {
        volunteers.add(volunteer);
    }

    public boolean removeVolunteer(String volunteerId) {
        for (int i = 0; i < volunteers.size(); i++) {
            if (volunteers.get(i).getId().equals(volunteerId)) {
                volunteers.remove(volunteers.get(i));
                return true;
            }
        }
        return false;
    }

    public Volunteer findVolunteerById(String volunteerId) {
        for (int i = 0; i < volunteers.size(); i++) {
            if (volunteers.get(i).getId().equals(volunteerId)) {
                return volunteers.get(i);
            }
        }
        return null;
    }

    public void assignVolunteerToEvent(String volunteerId, Event event) {
        Volunteer volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            volunteer.addEvent(event);
        }
    }

    public LinkedList<Event> getEventsForVolunteer(String volunteerId) {
        Volunteer volunteer = findVolunteerById(volunteerId);
        return volunteer != null ? volunteer.getEvents() : new LinkedList<>();
    }

    public LinkedList<Volunteer> getAllVolunteers() {
        return volunteers;
    }

    public LinkedList<Volunteer> filterVolunteers(String criteria) {
        LinkedList<Volunteer> filteredVolunteers = new LinkedList<>();
        for (int i = 0; i < volunteers.size(); i++) {
            if (volunteers.get(i).getName().toLowerCase().contains(criteria.toLowerCase())) {
                filteredVolunteers.add(volunteers.get(i));
            }
        }
        return filteredVolunteers;
    }

    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder("Volunteer Summary Report\n");
        report.append("Total number of volunteers: ").append(volunteers.size()).append("\n");
        // Add more summary information as needed
        return report.toString();
    }
}