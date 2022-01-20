package com.example.compravendita_libri_ium;

public enum BookCondition {
    COME_NUOVO("Libro come nuovo"),
    BUONE_CONDIZIONI("Libro usato ma in buone condizioni"),
    DISCRETE_CONDIZIONI("Libro usato ma in discrete condizioni");

    private final String description;

    BookCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
