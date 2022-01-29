package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.compravendita_libri_ium.activities.NewAdActivity;

public class NewAdBuilder implements Parcelable {
    private Book book;
    private BookCondition bookCondition;
    private BookSubCondition bookSubCondition;
    private double price;
    private MeetingPlace meetingPlace;
    private int[] photos;

    public NewAdBuilder() {
    }

    public Ad build() {
        return new Ad(new AdBase(book.toUsedBook(bookCondition, bookSubCondition), price, photos, meetingPlace), false);
    }

    public NewAdBuilder setBook(Book book) {
        this.book = book;
        return this;
    }

    public NewAdBuilder setCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
        return this;
    }

    public NewAdBuilder setSubCondition(BookSubCondition bookSubCondition) {
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

    public NewAdBuilder setPhotos(int[] photos) {
        this.photos = photos;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.book, flags);
        dest.writeInt(this.bookCondition == null ? -1 : this.bookCondition.ordinal());
        dest.writeInt(this.bookSubCondition == null ? -1 : this.bookSubCondition.ordinal());
        dest.writeDouble(this.price);
        dest.writeInt(this.meetingPlace == null ? -1 : this.meetingPlace.ordinal());
        dest.writeIntArray(this.photos);
    }

    public void readFromParcel(Parcel source) {
        this.book = source.readParcelable(Book.class.getClassLoader());
        int tmpBookCondition = source.readInt();
        this.bookCondition = tmpBookCondition == -1 ? null : BookCondition.values()[tmpBookCondition];
        int tmpBookSubCondition = source.readInt();
        this.bookSubCondition = tmpBookSubCondition == -1 ? null : BookSubCondition.values()[tmpBookSubCondition];
        this.price = source.readDouble();
        int tmpMeetingPlace = source.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
        this.photos = source.createIntArray();
    }

    protected NewAdBuilder(Parcel in) {
        this.book = in.readParcelable(Book.class.getClassLoader());
        int tmpBookCondition = in.readInt();
        this.bookCondition = tmpBookCondition == -1 ? null : BookCondition.values()[tmpBookCondition];
        int tmpBookSubCondition = in.readInt();
        this.bookSubCondition = tmpBookSubCondition == -1 ? null : BookSubCondition.values()[tmpBookSubCondition];
        this.price = in.readDouble();
        int tmpMeetingPlace = in.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
        this.photos = in.createIntArray();
    }

    public static final Parcelable.Creator<NewAdBuilder> CREATOR = new Parcelable.Creator<NewAdBuilder>() {
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
