package com.example.compravendita_libri_ium;

public class Seller {

    private String name;
    private int id;
    private int reputation; //0, 1, 2, 3, 4, 5 stars

    public Seller(String name, int id, int reputation) {
        this.name = name;
        this.id = id;
        this.reputation = reputation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }
}
