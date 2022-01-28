package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class UsedBook implements Parcelable {

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
        dest.writeInt(this.subCondition == null ? -1 : this.subCondition.ordinal());
    }

    public void readFromParcel(Parcel source) {
        this.book = source.readParcelable(Book.class.getClassLoader());
        int tmpCondition = source.readInt();
        this.condition = tmpCondition == -1 ? null : BookCondition.values()[tmpCondition];
        int tmpSubCondition = source.readInt();
        this.subCondition = tmpSubCondition == -1 ? null : BookSubCondition.values()[tmpSubCondition];
    }

    protected UsedBook(Parcel in) {
        this.book = in.readParcelable(Book.class.getClassLoader());
        int tmpCondition = in.readInt();
        this.condition = tmpCondition == -1 ? null : BookCondition.values()[tmpCondition];
        int tmpSubCondition = in.readInt();
        this.subCondition = tmpSubCondition == -1 ? null : BookSubCondition.values()[tmpSubCondition];
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof UsedBook))
            return false;

        UsedBook usedBook = (UsedBook) o;

        return usedBook.getTitle().equals(getTitle()) &&
                usedBook.getAuthor().equals(getAuthor()) &&
                usedBook.getEdition() == (getEdition());
    }

    public static final Parcelable.Creator<UsedBook> CREATOR = new Parcelable.Creator<UsedBook>() {
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
