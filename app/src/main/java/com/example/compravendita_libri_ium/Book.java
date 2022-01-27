package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

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

    public String getDescription() {
        return "\nEdizione: " + edition + "\nAutore: " + author + "\nEditore: " + publisher + "\nISBN: " + isbn + '\n';
    }

    @Override
    public String toString() {
        return "Titolo: " + title + "\nEdizione: " + edition + "\nAutore: " + author + "\nEditore: " + publisher + "\nISBN: " + isbn + '\n';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.edition);
        dest.writeString(this.isbn);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.subject);
        dest.writeString(this.publisher);
    }

    public void readFromParcel(Parcel source) {
        this.edition = source.readInt();
        this.isbn = source.readString();
        this.title = source.readString();
        this.author = source.readString();
        this.subject = source.readString();
        this.publisher = source.readString();
    }

    protected Book(Parcel in) {
        this.edition = in.readInt();
        this.isbn = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.subject = in.readString();
        this.publisher = in.readString();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
