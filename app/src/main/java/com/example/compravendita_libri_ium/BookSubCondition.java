package com.example.compravendita_libri_ium;

public enum BookSubCondition {
    SOTT_MATITA_O_PENNA("Sottolineato a matita o penna"),
    SOTT_EVIDENZ("Sottolineato con evidenziatore"),
    PAGINE_PIEGHE("Pagine con pieghe"),
    EVIDENZ_INDELEB("Evidenziato indelebilmente"),
    APPUNTI_SU_PAGINE("Appunti scritti sulle pagine"),
    PAGINE_ROVINATE("Pagine rovinate");

    private final String description;

    BookSubCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
