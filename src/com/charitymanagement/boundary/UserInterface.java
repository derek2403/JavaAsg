package com.charitymanagement.boundary;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.control.*;
import com.charitymanagement.entity.Donor;
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
                // Add cases for other management options
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
        System.out.println("1. Manage Donors");
        System.out.println("2. Manage Donees");
        // Add other menu options
        System.out.println("0. Exit");
    }

    private void manageDonors() {
        boolean managing = true;
        while (managing) {
            displayDonorMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addNewDonor();
                    break;
                case 2:
                    removeDonor();
                    break;
                case 3:
                    updateDonorDetails();
                    break;
                case 4:
                    searchDonor();
                    break;
                case 5:
                    listDonorsWithDonations();
                    break;
                case 6:
                    filterDonors();
                    break;
                case 7:
                    categorizeDonors();
                    break;
                case 8:
                    generateDonorSummaryReport();
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayDonorMenu() {
        System.out.println("\n--- Donor Management ---");
        System.out.println("1. Add a new donor");
        System.out.println("2. Remove a donor");
        System.out.println("3. Update donor details");
        System.out.println("4. Search donor details");
        System.out.println("5. List donors with donations");
        System.out.println("6. Filter donors");
        System.out.println("7. Categorize donors");
        System.out.println("8. Generate summary report");
        System.out.println("0. Return to main menu");
    }

    private void addNewDonor() {
        String id = getStringInput("Enter donor ID: ");
        String name = getStringInput("Enter donor name: ");
        String type = getStringInput("Enter donor type (government/private/public): ");
        boolean isOrganization = getBooleanInput("Is this donor an organization? (true/false): ");

        Donor newDonor = new Donor(id, name, type, isOrganization);
        donorManagement.addDonor(newDonor);
        System.out.println("Donor added successfully.");
    }

    private void removeDonor() {
        String id = getStringInput("Enter donor ID to remove: ");
        boolean removed = donorManagement.removeDonor(id);
        if (removed) {
            System.out.println("Donor removed successfully.");
        } else {
            System.out.println("Donor not found.");
        }
    }

    private void updateDonorDetails() {
        String id = getStringInput("Enter donor ID to update: ");
        String name = getStringInput("Enter new name: ");
        String type = getStringInput("Enter new type (government/private/public): ");
        boolean isOrganization = getBooleanInput("Is this donor an organization? (true/false): ");

        boolean updated = donorManagement.updateDonorDetails(id, name, type, isOrganization);
        if (updated) {
            System.out.println("Donor details updated successfully.");
        } else {
            System.out.println("Donor not found.");
        }
    }

    private void searchDonor() {
        String id = getStringInput("Enter donor ID to search: ");
        Donor donor = donorManagement.findDonorById(id);
        if (donor != null) {
            System.out.println("Donor found: " + donor);
        } else {
            System.out.println("Donor not found.");
        }
    }

    private void listDonorsWithDonations() {
        System.out.println("\n--- Donors with Donations ---");
        donorManagement.listDonorsWithDonations();
    }

    private void filterDonors() {
        String type = getStringInput("Enter donor type to filter (government/private/public): ");
        boolean isOrganization = getBooleanInput("Filter for organizations? (true/false): ");

        LinkedList<Donor> filteredDonors = donorManagement.filterDonors(type, isOrganization);
        System.out.println("\n--- Filtered Donors ---");
        for (int i = 0; i < filteredDonors.size(); i++) {
            System.out.println(filteredDonors.get(i));
        }
    }

    private void categorizeDonors() {
        String category = getStringInput("Enter category to list (government/private/public): ");
        LinkedList<Donor> categorizedDonors = donorManagement.getDonorsByCategory(category);
        System.out.println("\n--- Donors in category: " + category + " ---");
        for (int i = 0; i < categorizedDonors.size(); i++) {
            System.out.println(categorizedDonors.get(i));
        }
    }

    private void generateDonorSummaryReport() {
        String report = donorManagement.generateSummaryReport();
        System.out.println("\n--- Donor Summary Report ---");
        System.out.println(report);
    }

    private void manageDonees() {
        // Implement donee management menu and operations
    }

    // Utility methods for input handling
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
        return scanner.nextLine().trim();
    }

    private boolean getBooleanInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Invalid input. Please enter true or false.");
            scanner.next();
        }
        boolean input = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
        return input;
    }
}