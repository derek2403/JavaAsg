package com.charitymanagement.control;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.entity.Donation;
import com.charitymanagement.entity.Donor;

public class DonorManagement {
    private LinkedList<Donor> donors;

    public DonorManagement() {
        donors = new LinkedList<>();
    }

    // Add a new donor
    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    // Remove a donor
    public boolean removeDonor(String donorId) {
        for (int i = 0; i < donors.size(); i++) {
            if (donors.get(i).getId().equals(donorId)) {
                donors.remove(donors.get(i));
                return true;
            }
        }
        return false;
    }

    // Update donor details
    public boolean updateDonorDetails(String donorId, String name, String type, boolean isOrganization) {
        Donor donor = findDonorById(donorId);
        if (donor != null) {
            donor.setName(name);
            donor.setType(type);
            donor.setOrganization(isOrganization);
            return true;
        }
        return false;
    }

    // Search donor details
    public Donor findDonorById(String donorId) {
        for (int i = 0; i < donors.size(); i++) {
            if (donors.get(i).getId().equals(donorId)) {
                return donors.get(i);
            }
        }
        return null;
    }

    // List donors with all the donations made
    public void listDonorsWithDonations() {
        for (int i = 0; i < donors.size(); i++) {
            Donor donor = donors.get(i);
            System.out.println(donor);
            System.out.println("Donations:");
            LinkedList<Donation> donations = donor.getDonations();
            for (int j = 0; j < donations.size(); j++) {
                System.out.println("  " + donations.get(j));
            }
            System.out.println();
        }
    }

    // Filter donors based on criteria
    public LinkedList<Donor> filterDonors(String type, boolean isOrganization) {
        LinkedList<Donor> filteredDonors = new LinkedList<>();
        for (int i = 0; i < donors.size(); i++) {
            Donor donor = donors.get(i);
            if (donor.getType().equals(type) && donor.isOrganization() == isOrganization) {
                filteredDonors.add(donor);
            }
        }
        return filteredDonors;
    }

    // Categorize donors (type: government, private, public)
    public LinkedList<Donor> getDonorsByCategory(String category) {
        LinkedList<Donor> categorizedDonors = new LinkedList<>();
        for (int i = 0; i < donors.size(); i++) {
            if (donors.get(i).getType().equalsIgnoreCase(category)) {
                categorizedDonors.add(donors.get(i));
            }
        }
        return categorizedDonors;
    }

    // Generate summary report
    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder("Donor Summary Report\n");
        report.append("Total number of donors: ").append(donors.size()).append("\n");

        int governmentDonors = 0;
        int privateDonors = 0;
        int publicDonors = 0;
        int organizationDonors = 0;
        int individualDonors = 0;

        for (int i = 0; i < donors.size(); i++) {
            Donor donor = donors.get(i);
            switch (donor.getType().toLowerCase()) {
                case "government":
                    governmentDonors++;
                    break;
                case "private":
                    privateDonors++;
                    break;
                case "public":
                    publicDonors++;
                    break;
            }
            if (donor.isOrganization()) {
                organizationDonors++;
            } else {
                individualDonors++;
            }
        }

        report.append("Government donors: ").append(governmentDonors).append("\n");
        report.append("Private donors: ").append(privateDonors).append("\n");
        report.append("Public donors: ").append(publicDonors).append("\n");
        report.append("Organization donors: ").append(organizationDonors).append("\n");
        report.append("Individual donors: ").append(individualDonors).append("\n");

        return report.toString();
    }

    // Get all donors
    public LinkedList<Donor> getAllDonors() {
        return donors;
    }
}
