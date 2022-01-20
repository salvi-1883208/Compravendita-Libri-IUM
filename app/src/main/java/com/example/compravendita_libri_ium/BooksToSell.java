package com.example.compravendita_libri_ium;

import java.util.List;

public class BooksToSell {

    private static BooksToSell instance = null;

    private static List<Book> books;

    private BooksToSell() {
        books.add(new Book("Algoritmi e strutture dati", 2009, "Maurizio Rossi", "Cittàstudi", "7406713066", "Algoritmi"));
        books.add(new Book("Elementi di Fisica", 2008, "Claudio Gialli", "Cittàstudi", "8737592865", "Fisica"));
        books.add(new Book("Lezioni di Fisica I", 2008, "Mario Rossi", "Zanichelli", "0123456789", "Fisica"));
        books.add(new Book("Lezioni di Fisica I", 2011, "Mario Rossi", "Zanichelli", "10234789456", "Fisica"));
        books.add(new Book("Analisi Matematica I", 2005, " Rossi", "Zanichelli", "0864297531", "Algebra"));
    }

    //Singleton
    public static BooksToSell getInstance() {
        if(instance == null)
            instance = new BooksToSell();
        return instance;
    }

    public static List<Book> getBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }
}
