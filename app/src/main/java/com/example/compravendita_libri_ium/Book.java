package com.example.compravendita_libri_ium;

public class Book {

    private int edition;
    private String isbn;
    private String title;
    private String author;
    private String subject;
    private String publisher;


    public Book(String title, int edition, String author, String publisher, String isbn, String subject) {
        this.title = title;
        this.edition = edition;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.subject = subject;
    }

    public UsedBook toUsedBook(BookCondition condition, BookSubCondition subCondition) {
        return new UsedBook(this, condition, subCondition);
    }

    public UsedBook toUsedBook(BookCondition condition) {
        return new UsedBook(this, condition);
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
        return "\nTitolo:\t" + title + "\nEdizione:\t" + edition + "\nAutore:\t" + author + "\nEditore:\t" + publisher + "\nISBN:\t" + isbn + '\n';
    }
}
