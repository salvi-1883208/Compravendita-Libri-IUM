package com.example.compravendita_libri_ium;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AdBase implements Parcelable {
    private UsedBook usedBook;
    private double price;
    private ArrayList<Uri> photos;
    private MeetingPlace meetingPlace;

    public AdBase(UsedBook book, double price, ArrayList<Uri> photos, MeetingPlace meetingPlace) {
        this.usedBook = book;
        this.price = price;
        this.photos = photos;
        this.meetingPlace = meetingPlace;
    }

    public UsedBook getUsedBook() {
        return usedBook;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString() {
        return price % 1 == 0 ? Math.round(price) + "€" : price + "€";
    }

    public ArrayList<Uri> getPhotos() {
        return photos;
    }

    public MeetingPlace getMeetingPlace() {
        return meetingPlace;
    }

    @Override
    public String toString() {
        return usedBook +
                "Prezzo: " + price + '€' +
                "\nPunto di incontro: " + meetingPlace;
    }

    public static final Uri drawableToUri(int drawableId) {
        return Uri.parse("android.resource://com.example.compravendita_libri_ium/" + drawableId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof AdBase))
            return false;

        AdBase adBase = (AdBase) o;

        return adBase.getUsedBook().equals(usedBook) &&
                adBase.getMeetingPlace().equals(meetingPlace) &&
                adBase.getPrice() == price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.usedBook, flags);
        dest.writeDouble(this.price);
        dest.writeTypedList(this.photos);
        dest.writeInt(this.meetingPlace == null ? -1 : this.meetingPlace.ordinal());
    }

    public void readFromParcel(Parcel source) {
        this.usedBook = source.readParcelable(UsedBook.class.getClassLoader());
        this.price = source.readDouble();
        this.photos = source.createTypedArrayList(Uri.CREATOR);
        int tmpMeetingPlace = source.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
    }

    protected AdBase(Parcel in) {
        this.usedBook = in.readParcelable(UsedBook.class.getClassLoader());
        this.price = in.readDouble();
        this.photos = in.createTypedArrayList(Uri.CREATOR);
        int tmpMeetingPlace = in.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
    }

    public static final Creator<AdBase> CREATOR = new Creator<AdBase>() {
        @Override
        public AdBase createFromParcel(Parcel source) {
            return new AdBase(source);
        }

        @Override
        public AdBase[] newArray(int size) {
            return new AdBase[size];
        }
    };
}
