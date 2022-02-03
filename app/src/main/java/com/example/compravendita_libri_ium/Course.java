package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Course implements Parcelable {
    private ArrayList<AdsBook> adsBook = new ArrayList<>();  //lista di tutti gli annunci di libri  per quel corso
    private String courseName;
    private int availableBooks = 0;     //libri disponibili
    private int suggestedBooks;         //libri suggeriti

    public Course(String courseName) {
        this.courseName = courseName;

        //libri suggeriti
        for (Books book : Books.values())
            if (book.getBook().getSubject().equalsIgnoreCase(courseName))
                adsBook.add(new AdsBook(book.getBook(), new ArrayList<>()));


        //libri disponibili
        for (Ads ad : Ads.values())
            if (ad.getAd().getAdBase().getUsedBook().getSubject().equalsIgnoreCase(courseName))
                for (AdsBook adBook : adsBook)
                    if (adBook.getBook().equals(ad.getAd().getAdBase().getUsedBook().getBook())) {
                        adBook.addAd(ad.getAd());
                        availableBooks++;
                    }

        suggestedBooks = adsBook.size();
    }

    public ArrayList<AdsBook> getAdsBook() {
        return adsBook;
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

    public void removeAd(Ad ad) {
        adsBook.remove(ad);
        availableBooks--;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.adsBook);
        dest.writeString(this.courseName);
        dest.writeInt(this.availableBooks);
        dest.writeInt(this.suggestedBooks);
    }

    public void readFromParcel(Parcel source) {
        this.adsBook = new ArrayList<AdsBook>();
        source.readList(this.adsBook, AdsBook.class.getClassLoader());
        this.courseName = source.readString();
        this.availableBooks = source.readInt();
        this.suggestedBooks = source.readInt();
    }

    protected Course(Parcel in) {
        this.adsBook = new ArrayList<AdsBook>();
        in.readList(this.adsBook, AdsBook.class.getClassLoader());
        this.courseName = in.readString();
        this.availableBooks = in.readInt();
        this.suggestedBooks = in.readInt();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
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
