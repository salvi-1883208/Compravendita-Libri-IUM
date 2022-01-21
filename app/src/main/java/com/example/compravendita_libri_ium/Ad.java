package com.example.compravendita_libri_ium;

import android.media.Image;

import java.util.Arrays;

public class Ad {
    private boolean approved = false;
    private UsedBook book;
    private double price;
    private Image[] photos;
    private MeetingPlace meetingPlace;

    public Ad(UsedBook book, double price, Image[] photos, MeetingPlace meetingPlace){
        this.book = book;
        this.price = price;
        this.photos = photos;
        this.meetingPlace = meetingPlace;
    }

    public UsedBook getBook() {
        return book;
    }

    public boolean isApproved() {
        return approved;
    }

    public double getPrice() {
        return price;
    }

    public Image[] getPhotos() {
        return photos;
    }

    public MeetingPlace getMeetingPlace() {
        return meetingPlace;
    }

    public void approve() {
        approved = true;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "approved=" + approved +
                ", book=" + book +
                ", price=" + price +
                ", photos=" + Arrays.toString(photos) +
                ", meetingPlace=" + meetingPlace +
                '}';
    }
}
