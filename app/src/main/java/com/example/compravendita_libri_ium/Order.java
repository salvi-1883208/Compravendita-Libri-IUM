package com.example.compravendita_libri_ium;

public class Order {

    private int timeRemaining = 10080; //In minutes
    private boolean completed = false;
    private Seller seller;
    private AdBase adBase;

    public Order(AdBase adBase, Seller seller) {
        this.seller = seller;
        this.adBase = adBase;
    }

    public Seller getSeller() {
        return seller;
    }

    public AdBase getAdBase() {
        return adBase;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void complete() {
        completed = true;
    }

}
