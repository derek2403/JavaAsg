package com.charitymanagement.boundary;

import java.util.Scanner;
import com.charitymanagement.control.*;

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
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
        System.out.print("Enter your choice: ");
    }

    private void manageDonors() {
        // Implement donor management menu and operations
    }

    private void manageDonees() {
        // Implement donee management menu and operations
    }

    // Add other management methods
}