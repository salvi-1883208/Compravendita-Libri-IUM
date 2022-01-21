package com.example.compravendita_libri_ium;

public enum Sellers {
    MAURIZIO_BIANCHI(new Seller("Maurizio Bianchi", 15639507, 5)),
    MATTEO_ROSSI(new Seller("Matteo Rossi", 1234567, 5)),
    MATTEO_BIANCHI(new Seller("Matteo Bianchi", 1334567, 3)),
    LORENZO_VERDI(new Seller("Lorenzo Verdi", 1334444, 4)),
    NICOLA_GALLI(new Seller("Nicola Galli", 1423232, 2));

    private Seller seller;

    Sellers(Seller seller){
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }
}
