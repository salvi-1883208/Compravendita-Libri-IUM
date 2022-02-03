package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class AdsBook implements Parcelable {

    private Book book;
    private ArrayList<Ad> ads;

    public AdsBook(Book book, ArrayList<Ad> ads) {
        this.ads = ads;
        this.book = book;
    }

    public ArrayList<Ad> getAds() {
        return ads;
    }

    public Book getBook() {
        return book;
    }

    public void addAd(Ad ad) {
        ads.add(ad);
    }

    public int getDisponibility() {
        return ads.size();
    }

    public boolean removeAd(Ad ad) {
        return ads.remove(ad);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.book, flags);
        dest.writeTypedList(this.ads);
    }

    public void readFromParcel(Parcel source) {
        this.book = source.readParcelable(Book.class.getClassLoader());
        this.ads = source.createTypedArrayList(Ad.CREATOR);
    }

    protected AdsBook(Parcel in) {
        this.book = in.readParcelable(Book.class.getClassLoader());
        this.ads = in.createTypedArrayList(Ad.CREATOR);
    }

    public static final Parcelable.Creator<AdsBook> CREATOR = new Parcelable.Creator<AdsBook>() {
        @Override
        public AdsBook createFromParcel(Parcel source) {
            return new AdsBook(source);
        }

        @Override
        public AdsBook[] newArray(int size) {
            return new AdsBook[size];
        }
    };
}
