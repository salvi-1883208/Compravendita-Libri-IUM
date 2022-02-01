package com.example.compravendita_libri_ium;


public enum Books {
    ALGORITMI_STR_DAT(new Book("Algoritmi e strutture dati", 2009, "Maurizio Rossi", "Cittàstudi", "7406713066", "Algoritmi")),
    ELEMENTI_FISICA(new Book("Elementi di Fisica", 2008, "Claudio Gialli", "Cittàstudi", "8737592865", "Fisica")),
    FISICA_I_2008(new Book("Lezioni di Fisica I", 2008, "Mario Rossi", "Zanichelli", "0123456789", "Fisica")),
    FISICA_I_2011(new Book("Lezioni di Fisica I", 2011, "Mario Rossi", "Zanichelli", "10234789456", "Fisica")),
    ANALISI_MAT(new Book("Analisi Matematica I", 2005, "Rossi", "Zanichelli", "0864297531", "Algebra")),
    FISICA_II_2008(new Book("Lezioni di Fisica II", 2008, "Mario Rossi", "Zanichelli", "098721452", "Fisica")),
    FISICA_II_2011(new Book("Lezioni di Fisica II", 2011, "Mario Rossi", "Zanichelli", "3215678900", "Fisica")),
    ANALISI_MAT_II(new Book("Analisi Matematica II", 2011, "Gianni Gialli", "Zanichelli", "29638729479", "Algebra"));

    private final Book book;

    Books(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}



