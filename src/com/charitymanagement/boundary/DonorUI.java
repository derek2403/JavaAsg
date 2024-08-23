package com.charitymanagement.boundary;

import com.charitymanagement.control.DonorManagement;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class DonorUI {
    private DonorManagement donorManagement;

    public DonorUI(DonorManagement donorManagement) {
        this.donorManagement = donorManagement;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("=== Donor Management ===");
            System.out.println("1. Add Donor");
            System.out.println("2. Remove Donor");
            System.out.println("3. Update Donor");
            System.out.println("4. Search Donor");
            System.out.println("5. List All Donors");
            System.out.println("6. Filter Donors by Type");
            System.out.println("7. Generate Summary Report");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDonor(scanner);
                    break;
                case 2:
                    removeDonor(scanner);
                    break;
                case 3:
                    updateDonor(scanner);
                    break;
                case 4:
                    searchDonor(scanner);
                    break;
                case 5:
                    donorManagement.listDonors();
                    break;
                case 6:
                    filterDonorsByType(scanner);
                    break;
                case 7:
                    donorManagement.generateSummaryReport();
                    break;
                case 8:
                    System.out.println("Exiting Donor Management.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    private void addDonor(Scanner scanner) {
        System.out.print("Enter donor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter donor type (government/private/public): ");
        String type = scanner.nextLine();
        donorManagement.addDonor(name, type);
        System.out.println("Donor added successfully.");
    }

    private void removeDonor(Scanner scanner) {
        System.out.print("Enter donor name to remove: ");
        String name = scanner.nextLine();
        try {
            donorManagement.removeDonor(name);
            System.out.println("Donor removed successfully.");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void updateDonor(Scanner scanner) {
        System.out.print("Enter donor name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new donor type (government/private/public): ");
        String newType = scanner.nextLine();
        try {
            donorManagement.updateDonor(name, newType);
            System.out.println("Donor updated successfully.");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchDonor(Scanner scanner) {
        System.out.print("Enter donor name to search: ");
        String name = scanner.nextLine();
        Donor donor = donorManagement.searchDonor(name);
        if (donor != null) {
            System.out.println("Donor found: " + donor);
        } else {
            System.out.println("Donor not found.");
        }
    }

    private void filterDonorsByType(Scanner scanner) {
        System.out.print("Enter donor type to filter by (government/private/public): ");
        String type = scanner.nextLine();
        donorManagement.filterDonorsByType(type);
    }
}
