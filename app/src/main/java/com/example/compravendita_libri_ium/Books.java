package com.example.compravendita_libri_ium;

public enum Books {
    ALGORITMI_STR_DAT(new Book("Algoritmi e strutture dati", 2009, "Maurizio Rossi", "Cittàstudi", "7406713066", "Algoritmi")),
    ELEMENTI_FISICA(new Book("Elementi di Fisica", 2008, "Claudio Gialli", "Cittàstudi", "8737592865", "Fisica")),
    FISICA_I_2008(new Book("Lezioni di Fisica I", 2008, "Mario Rossi", "Zanichelli", "0123456789", "Fisica")),
    FISICA_I_2011(new Book("Lezioni di Fisica I", 2011, "Mario Rossi", "Zanichelli", "10234789456", "Fisica")),
    ANALISI_MAT(new Book("Analisi Matematica I", 2005, " Rossi", "Zanichelli", "0864297531", "Algebra"));

    Books(Book book){
        this.book = book;
    }

    private final Book book;

    public Book getBook() {
        return book;
    }
}



