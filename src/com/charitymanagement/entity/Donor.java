package com.charitymanagement.entity;

import com.charitymanagement.adt.LinkedList;

public class Donor {
    private String id;
    private String name;
    private String type; // government, private, public
    private boolean isOrganization;
    private LinkedList<Donation> donations;

    public Donor(String id, String name, String type, boolean isOrganization) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.isOrganization = isOrganization;
        this.donations = new LinkedList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public boolean isOrganization() { return isOrganization; }
    public void setOrganization(boolean organization) { isOrganization = organization; }

    public void addDonation(Donation donation) {
        donations.add(donation);
    }

    public LinkedList<Donation> getDonations() {
        return donations;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isOrganization=" + isOrganization +
                ", donations=" + donations.size() +
                '}';
    }
}