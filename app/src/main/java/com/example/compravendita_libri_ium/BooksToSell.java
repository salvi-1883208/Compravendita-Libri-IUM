package com.example.compravendita_libri_ium;

import java.util.ArrayList;

public class BooksToSell {

    private static BooksToSell instance = null;

    private static ArrayList<Book> books = new ArrayList<>();


    // Books to sell (the books you choose and then create an ad for adding the conditions...)
    private BooksToSell() {
        books.add(Books.ALGORITMI_STR_DAT.getBook());
        books.add(Books.ANALISI_MAT.getBook());
        books.add(Books.ANALISI_MAT_II.getBook());
        books.add(Books.ELEMENTI_FISICA.getBook());
        books.add(Books.FISICA_I_2008.getBook());
        books.add(Books.FISICA_I_2011.getBook());
        books.add(Books.FISICA_II_2008.getBook());
        books.add(Books.FISICA_II_2011.getBook());
    }

    //Singleton
    public static BooksToSell getInstance() {
        if (instance == null)
            instance = new BooksToSell();
        return instance;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
