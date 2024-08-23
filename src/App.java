package com.charitymanagement;

import com.charitymanagement.boundary.DonorUI;
import com.charitymanagement.control.DonorManagement;

public class App {
    public static void main(String[] args) {
        DonorManagement donorManagement = new DonorManagement();
        DonorUI donorUI = new DonorUI(donorManagement);
        donorUI.displayMenu();
    }
}
