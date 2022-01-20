package com.example.compravendita_libri_ium;

import java.util.List;

public class BooksToSell {

    private static BooksToSell instance = null;

    private static List<Book> books;

    private BooksToSell() {
        books.add(Books.FISICA_I_2008.getBook());
        books.add(Books.FISICA_I_2011.getBook());
        books.add(Books.FISICA_I_2008.getBook());
    }

    //Singleton
    public static BooksToSell getInstance() {
        if (instance == null)
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
