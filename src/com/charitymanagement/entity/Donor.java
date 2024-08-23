package com.charitymanagement.entity;

import java.util.ArrayList;
import java.util.List;

public class Donor {
    private String name;
    private String type; // government, private, public
    private List<Donation> donations;

    public Donor(String name, String type) {
        this.name = name;
        this.type = type;
        this.donations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void addDonation(Donation donation) {
        this.donations.add(donation);
    }

    @Override
    public String toString() {
        return "Donor{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", donations=" + donations +
                '}';
    }
}
