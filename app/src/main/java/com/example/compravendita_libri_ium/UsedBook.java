package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class UsedBook implements Parcelable {

    private Book book;
    private BookCondition condition;
    private ArrayList<BookSubCondition> subConditions = null;

    public UsedBook(Book book, BookCondition bookCondition, ArrayList<BookSubCondition> bookSubConditions) {
        this.book = book;
        this.condition = bookCondition;
        this.subConditions = bookSubConditions;
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

    public ArrayList<BookSubCondition> getSubConditions() {
        return subConditions;
    }

    @Override
    public String toString() {
        return book.toString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.book, flags);
        dest.writeInt(this.condition == null ? -1 : this.condition.ordinal());
        dest.writeList(this.subConditions);
    }

    public void readFromParcel(Parcel source) {
        this.book = source.readParcelable(Book.class.getClassLoader());
        int tmpCondition = source.readInt();
        this.condition = tmpCondition == -1 ? null : BookCondition.values()[tmpCondition];
        this.subConditions = new ArrayList<BookSubCondition>();
        source.readList(this.subConditions, BookSubCondition.class.getClassLoader());
    }

    protected UsedBook(Parcel in) {
        this.book = in.readParcelable(Book.class.getClassLoader());
        int tmpCondition = in.readInt();
        this.condition = tmpCondition == -1 ? null : BookCondition.values()[tmpCondition];
        this.subConditions = new ArrayList<BookSubCondition>();
        in.readList(this.subConditions, BookSubCondition.class.getClassLoader());
    }

    public static final Creator<UsedBook> CREATOR = new Creator<UsedBook>() {
        @Override
        public UsedBook createFromParcel(Parcel source) {
            return new UsedBook(source);
        }

        @Override
        public UsedBook[] newArray(int size) {
            return new UsedBook[size];
        }
    };
}
