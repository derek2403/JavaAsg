package com.charitymanagement.control;

import com.charitymanagement.adt.LinkedList;
import com.charitymanagement.entity.Donor;

public class DonorManagement {
    private LinkedList<Donor> donors;

    public DonorManagement() {
        donors = new LinkedList<>();
    }

    public void addDonor(Donor donor) {
        donors.add(donor);
    }

    // Other methods for managing donors
}