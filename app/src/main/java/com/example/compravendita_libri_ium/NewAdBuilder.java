package com.example.compravendita_libri_ium;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.compravendita_libri_ium.activities.NewAdActivity;

import java.util.ArrayList;

public class NewAdBuilder implements Parcelable {
    private Book book;
    private BookCondition bookCondition;
    private ArrayList<BookSubCondition> bookSubCondition = null;
    private double price;
    private MeetingPlace meetingPlace;
    private ArrayList<Uri> photos;

    public NewAdBuilder() {
    }

    public Ad build() {                                                                //devo aggiustare qui
        return new Ad(new AdBase(book.toUsedBook(bookCondition, bookSubCondition), price, new int[]{}, meetingPlace), false);
    }

    public NewAdBuilder setBook(Book book) {
        this.book = book;
        return this;
    }

    public NewAdBuilder setCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
        return this;
    }

    public NewAdBuilder setSubCondition(ArrayList<BookSubCondition> bookSubCondition) {
        this.bookSubCondition = bookSubCondition;
        return this;
    }

    public NewAdBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public NewAdBuilder setMeetingPlace(MeetingPlace meetingPlace) {
        this.meetingPlace = meetingPlace;
        return this;
    }

    public NewAdBuilder setPhotos(ArrayList<Uri> photos) {
        this.photos = photos;
        return this;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public boolean hasSubCondition() {
        return !bookSubCondition.isEmpty();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.book, flags);
        dest.writeInt(this.bookCondition == null ? -1 : this.bookCondition.ordinal());
        dest.writeList(this.bookSubCondition);
        dest.writeDouble(this.price);
        dest.writeInt(this.meetingPlace == null ? -1 : this.meetingPlace.ordinal());
        dest.writeTypedList(this.photos);
    }

    public void readFromParcel(Parcel source) {
        this.book = source.readParcelable(Book.class.getClassLoader());
        int tmpBookCondition = source.readInt();
        this.bookCondition = tmpBookCondition == -1 ? null : BookCondition.values()[tmpBookCondition];
        this.bookSubCondition = new ArrayList<BookSubCondition>();
        source.readList(this.bookSubCondition, BookSubCondition.class.getClassLoader());
        this.price = source.readDouble();
        int tmpMeetingPlace = source.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
        this.photos = source.createTypedArrayList(Uri.CREATOR);
    }

    protected NewAdBuilder(Parcel in) {
        this.book = in.readParcelable(Book.class.getClassLoader());
        int tmpBookCondition = in.readInt();
        this.bookCondition = tmpBookCondition == -1 ? null : BookCondition.values()[tmpBookCondition];
        this.bookSubCondition = new ArrayList<BookSubCondition>();
        in.readList(this.bookSubCondition, BookSubCondition.class.getClassLoader());
        this.price = in.readDouble();
        int tmpMeetingPlace = in.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
        this.photos = in.createTypedArrayList(Uri.CREATOR);
    }

    public static final Creator<NewAdBuilder> CREATOR = new Creator<NewAdBuilder>() {
        @Override
        public NewAdBuilder createFromParcel(Parcel source) {
            return new NewAdBuilder(source);
        }

        @Override
        public NewAdBuilder[] newArray(int size) {
            return new NewAdBuilder[size];
        }
    };
}
