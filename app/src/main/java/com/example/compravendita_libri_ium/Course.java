package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Course implements Parcelable {
    private ArrayList<Ad> ads = new ArrayList<>();  //lista di tutti gli annunci di libri  per quel corso
    private String courseName;
    private int availableBooks = 0;     //libri disponibili
    private int suggestedBooks;         //libri suggeriti

    public Course(String courseName) {
        this.courseName = courseName;

        //libri suggeriti
        for (Books book : Books.values())
            if (book.getBook().getSubject().equalsIgnoreCase(courseName))
                suggestedBooks++;

        //libri disponibili
        for (Ads ad : Ads.values())
            if (ad.getAd().getAdBase().getUsedBook().getSubject().equalsIgnoreCase(courseName))
                ads.add(ad.getAd());
        availableBooks = ads.size();
    }

    public ArrayList<Ad> getAds() {
        return ads;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public int getSuggestedBooks() {
        return suggestedBooks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.ads);
        dest.writeString(this.courseName);
        dest.writeInt(this.availableBooks);
        dest.writeInt(this.suggestedBooks);
    }

    public void readFromParcel(Parcel source) {
        this.ads = source.createTypedArrayList(Ad.CREATOR);
        this.courseName = source.readString();
        this.availableBooks = source.readInt();
        this.suggestedBooks = source.readInt();
    }

    protected Course(Parcel in) {
        this.ads = in.createTypedArrayList(Ad.CREATOR);
        this.courseName = in.readString();
        this.availableBooks = in.readInt();
        this.suggestedBooks = in.readInt();
    }

    public static final Parcelable.Creator<Course> CREATOR = new Parcelable.Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel source) {
            return new Course(source);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };
}
