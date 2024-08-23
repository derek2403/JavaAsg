package com.charitymanagement.boundary;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.control.*;
import com.charitymanagement.entity.Event;
import com.charitymanagement.entity.Volunteer;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private DonorManagement donorManagement;
    private DoneeManagement doneeManagement;
    private DonationManagement donationManagement;
    private DonationDistribution donationDistribution;
    private VolunteerManagement volunteerManagement;
    private EventManagement eventManagement;

    public UserInterface() {
        scanner = new Scanner(System.in);
        donorManagement = new DonorManagement();
        doneeManagement = new DoneeManagement();
        donationManagement = new DonationManagement();
        donationDistribution = new DonationDistribution();
        volunteerManagement = new VolunteerManagement();
        eventManagement = new EventManagement();
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    manageDonors();
                    break;
                case 2:
                    manageDonees();
                    break;
                case 3:
                    manageDonations();
                    break;
                case 4:
                    manageDonationDistribution();
                    break;
                case 5:
                    manageVolunteers();
                    break;
                case 6:
                    manageEvents();
                    break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using the Charity Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n--- Charity Management System ---");
        System.out.println("1. Donor Management");
        System.out.println("2. Donee Management");
        System.out.println("3. Donation Management");
        System.out.println("4. Donation Distribution");
        System.out.println("5. Volunteer Management");
        System.out.println("6. Event Management");
        System.out.println("0. Exit");
    }

    private void manageDonors() {
        // Existing donor management code...
    }

    private void manageDonees() {
        System.out.println("Donee Management - Not implemented yet");
    }

    private void manageDonations() {
        System.out.println("Donation Management - Not implemented yet");
    }

    private void manageDonationDistribution() {
        System.out.println("Donation Distribution - Not implemented yet");
    }

    private void manageVolunteers() {
        boolean managing = true;
        while (managing) {
            displayVolunteerMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    Volunteer newVolunteer = getVolunteerDetailsFromUser();
                    volunteerManagement.addVolunteer(newVolunteer);
                    System.out.println("Volunteer added successfully.");
                    break;
                case 2:
                    String volunteerIdToRemove = getStringInput("Enter the Volunteer ID to remove: ");
                    boolean removed = volunteerManagement.removeVolunteer(volunteerIdToRemove);
                    System.out.println(removed ? "Volunteer removed successfully." : "Volunteer not found.");
                    break;
                case 3:
                    String volunteerIdToSearch = getStringInput("Enter the Volunteer ID to search: ");
                    Volunteer foundVolunteer = volunteerManagement.findVolunteerById(volunteerIdToSearch);
                    System.out.println(foundVolunteer != null ? foundVolunteer : "Volunteer not found.");
                    break;
                case 4:
                    String volunteerIdToAssign = getStringInput("Enter the Volunteer ID to assign to an event: ");
                    Event eventToAssign = getEventDetailsFromUser();
                    volunteerManagement.assignVolunteerToEvent(volunteerIdToAssign, eventToAssign);
                    break;
                case 5:
                    String volunteerIdForEvents = getStringInput("Enter the Volunteer ID to list events for: ");
                    LinkedList<Event> eventsForVolunteer = volunteerManagement.getEventsForVolunteer(volunteerIdForEvents);
                    for (int i = 0; i < eventsForVolunteer.size(); i++) {
                        System.out.println(eventsForVolunteer.get(i));
                    }
                    break;
                case 6:
                    LinkedList<Volunteer> allVolunteers = volunteerManagement.getAllVolunteers();
                    for (int i = 0; i < allVolunteers.size(); i++) {
                        System.out.println(allVolunteers.get(i));
                    }
                    break;
                case 7:
                    String filterCriteria = getStringInput("Enter the criteria to filter volunteers by: ");
                    LinkedList<Volunteer> filteredVolunteers = volunteerManagement.filterVolunteers(filterCriteria);
                    for (int i = 0; i < filteredVolunteers.size(); i++) {
                        System.out.println(filteredVolunteers.get(i));
                    }
                    break;
                case 8:
                    System.out.println(volunteerManagement.generateSummaryReport());
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayVolunteerMenu() {
        System.out.println("\n--- Volunteer Management ---");
        System.out.println("1. Add a new volunteer");
        System.out.println("2. Remove a volunteer");
        System.out.println("3. Search volunteer");
        System.out.println("4. Assign volunteer to event");
        System.out.println("5. List events for a volunteer");
        System.out.println("6. List all volunteers");
        System.out.println("7. Filter volunteers");
        System.out.println("8. Generate summary report");
        System.out.println("0. Return to main menu");
    }

    private void manageEvents() {
        boolean managing = true;
        while (managing) {
            displayEventMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    Event newEvent = getEventDetailsFromUser();
                    eventManagement.addEvent(newEvent);
                    break;
                case 2:
                    String eventIdToRemove = getStringInput("Enter the Event ID to remove: ");
                    boolean removed = eventManagement.removeEvent(eventIdToRemove);
                    System.out.println(removed ? "Event removed successfully." : "Event not found.");
                    break;
                case 3:
                    String eventIdToUpdate = getStringInput("Enter the Event ID to update: ");
                    String name = getStringInput("Enter the new name: ");
                    String date = getStringInput("Enter the new date: ");
                    boolean updated = eventManagement.updateEventDetails(eventIdToUpdate, name, date);
                    System.out.println(updated ? "Event updated successfully." : "Event not found.");
                    break;
                case 4:
                    String eventIdToSearch = getStringInput("Enter the Event ID to search: ");
                    Event foundEvent = eventManagement.findEventById(eventIdToSearch);
                    System.out.println(foundEvent != null ? foundEvent : "Event not found.");
                    break;
                case 5:
                    LinkedList<Event> allEvents = eventManagement.getAllEvents();
                    for (int i = 0; i < allEvents.size(); i++) {
                        System.out.println(allEvents.get(i));
                    }
                    break;
                    case 6:
                    String eventIdToRemoveVolunteer = getStringInput("Enter the Event ID: ");
                    String volunteerId = getStringInput("Enter the Volunteer ID: ");
                    Volunteer volunteer = volunteerManagement.findVolunteerById(volunteerId);
                    if (volunteer != null) {
                        boolean removedFromVolunteer = eventManagement.removeEventFromVolunteer(eventIdToRemoveVolunteer, volunteer);
                        System.out.println(removedFromVolunteer ? "Event removed from volunteer successfully." : "Event or volunteer not found.");
                    } else {
                        System.out.println("Volunteer not found.");
                    }
                    break;
                case 7:
                    String volunteerIdForEvents = getStringInput("Enter the Volunteer ID: ");
                    Volunteer volunteerToSearch = volunteerManagement.findVolunteerById(volunteerIdForEvents);
                    if (volunteerToSearch != null) {
                        LinkedList<Event> eventsForVolunteer = eventManagement.getEventsForVolunteer(volunteerToSearch);
                        for (int i = 0; i < eventsForVolunteer.size(); i++) {
                            System.out.println(eventsForVolunteer.get(i));
                        }
                    } else {
                        System.out.println("Volunteer not found.");
                    }
                    break;
                case 8:
                    System.out.println(eventManagement.generateSummaryReport());
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayEventMenu() {
        System.out.println("\n--- Event Management ---");
        System.out.println("1. Add a new event");
        System.out.println("2. Remove an event");
        System.out.println("3. Update event details");
        System.out.println("4. Search an event");
        System.out.println("5. List all events");
        System.out.println("6. Remove an event from a volunteer");
        System.out.println("7. List events for a volunteer");
        System.out.println("8. Generate summary report");
        System.out.println("0. Return to main menu");
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return input;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private boolean getBooleanInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true or false.");
            scanner.next();
        }
        return scanner.nextBoolean();
    }

    private Volunteer getVolunteerDetailsFromUser() {
        String id = getStringInput("Enter volunteer ID: ");
        String name = getStringInput("Enter volunteer name: ");
        return new Volunteer(id, name);
    }

    private Event getEventDetailsFromUser() {
        String id = getStringInput("Enter event ID: ");
        String name = getStringInput("Enter event name: ");
        String date = getStringInput("Enter event date: ");
        return new Event(id, name, date);
    }
}