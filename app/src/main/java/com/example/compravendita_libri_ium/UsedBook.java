package com.example.compravendita_libri_ium;

public class UsedBook {

    private Book book;
    private BookCondition condition;
    private BookSubCondition subCondition = null;

    public UsedBook(Book book, BookCondition bookCondition, BookSubCondition bookSubCondition) {
        this.book = book;
        this.condition = bookCondition;
        this.subCondition = bookSubCondition;
    }

    public UsedBook(Book book, BookCondition bookCondition) {
        this.book = book;
        this.condition = bookCondition;
    }

    public String getTitle() {
        return book.getTitle();
    }

    public int getEdition() {
        return book.getEdition();
    }

    public String getAuthor() {
        return book.getAuthor();
    }

    public String getPublisher() {
        return book.getPublisher();
    }

    public String getIsbn() {
        return book.getIsbn();
    }

    public String getSubject() {
        return book.getSubject();
    }

    public BookCondition getCondition() {
        return condition;
    }

    public BookSubCondition getSubCondition() {
        return subCondition;
    }

    @Override
    public String toString() {
        return book.toString() + "Condizione:\t" + condition.getDescription() + "\nCondizione specifica:\t" + subCondition.getDescription() + '\n';
    }
}
