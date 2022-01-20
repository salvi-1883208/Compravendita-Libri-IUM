package com.example.compravendita_libri_ium;

public class Book {

    private String title;
    private int edition;
    private String author;
    private String publisher;
    private String isbn;
    private String subject;


    public Book(String title, int edition, String author, String publisher, String isbn, String subject) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public int getEdition() {
        return edition;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "\nTitolo:\t" + title + "\nEdizione:\t" + edition + "\nAutore:\t" + author + "\nEditore:\t" + publisher + "\nISBN:\t" + isbn;
    }
}
