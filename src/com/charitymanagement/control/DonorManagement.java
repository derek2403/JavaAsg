package com.charitymanagement.control;

import com.charitymanagement.adt.MyLinkedList;
import com.charitymanagement.entity.Donor;

import java.util.NoSuchElementException;

public class DonorManagement {
    private MyLinkedList<Donor> donors;

    public DonorManagement() {
        donors = new MyLinkedList<>();
    }

    public void addDonor(String name, String type) {
        Donor newDonor = new Donor(name, type);
        donors.add(newDonor);
    }

    public void removeDonor(String name) throws NoSuchElementException {
        Donor donor = searchDonor(name);
        if (donor == null) {
            throw new NoSuchElementException("Donor not found");
        }
        donors.remove(donor);
    }

    public void updateDonor(String name, String newType) throws NoSuchElementException {
        Donor donor = searchDonor(name);
        if (donor == null) {
            throw new NoSuchElementException("Donor not found");
        }
        donor.setType(newType);
    }

    public Donor searchDonor(String name) {
        return donors.search(new Donor(name, null));
    }

    public void listDonors() {
        donors.display();
    }

    public void filterDonorsByType(String type) {
        MyLinkedList<Donor> filtered = donors.filter(donor -> donor.getType().equalsIgnoreCase(type));
        filtered.display();
    }

    public void generateSummaryReport() {
        System.out.println("Summary Report");
        donors.display();
    }
}
