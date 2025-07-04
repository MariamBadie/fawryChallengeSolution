package com.example.fawryChallengeSolution.models;

public class Mobile extends Product {
    public Mobile(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
