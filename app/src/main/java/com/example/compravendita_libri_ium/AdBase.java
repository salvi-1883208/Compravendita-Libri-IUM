package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class AdBase implements Parcelable {
    private UsedBook usedBook;
    private double price;
    private int[] photosId;
    private MeetingPlace meetingPlace;

    public AdBase(UsedBook book, double price, int[] photosId, MeetingPlace meetingPlace) {
        this.usedBook = book;
        this.price = price;
        this.photosId = photosId;
        this.meetingPlace = meetingPlace;
    }

    public UsedBook getUsedBook() {
        return usedBook;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString() {
        return price % 1 == 0 ? Long.toString(Math.round(price)) + "€" : Double.toString(price) + "€";
    }

    public int[] getPhotos() {
        return photosId;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.usedBook, flags);
        dest.writeDouble(this.price);
        dest.writeIntArray(this.photosId);
        dest.writeInt(this.meetingPlace == null ? -1 : this.meetingPlace.ordinal());
    }

    public void readFromParcel(Parcel source) {
        this.usedBook = source.readParcelable(UsedBook.class.getClassLoader());
        this.price = source.readDouble();
        this.photosId = source.createIntArray();
        int tmpMeetingPlace = source.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
    }

    protected AdBase(Parcel in) {
        this.usedBook = in.readParcelable(UsedBook.class.getClassLoader());
        this.price = in.readDouble();
        this.photosId = in.createIntArray();
        int tmpMeetingPlace = in.readInt();
        this.meetingPlace = tmpMeetingPlace == -1 ? null : MeetingPlace.values()[tmpMeetingPlace];
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

    public static final Parcelable.Creator<AdBase> CREATOR = new Parcelable.Creator<AdBase>() {
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
