package com.example.compravendita_libri_ium;

import android.media.Image;

import java.util.Arrays;

public class Ad {
    private boolean approved = false;
    private boolean completed = false;
    private UsedBook book;
    private double price;
    private int[] photosId;
    private MeetingPlace meetingPlace;

    public Ad(UsedBook book, double price, int[] photosId, MeetingPlace meetingPlace) {
        this.book = book;
        this.price = price;
        this.photosId = photosId;
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

    public int[] getPhotos() {
        return photosId;
    }

    public MeetingPlace getMeetingPlace() {
        return meetingPlace;
    }

    public void approve() {
        approved = true;
    }

    public void complete() throws Exception {
        if (approved)
            completed = true;
        else
            throw new Exception("You can't complete an order if the ad is not approved yet");
    }


    @Override
    public String toString() {
        return "Ad{" +
                "approved=" + approved +
                ", book=" + book +
                ", price=" + price +
                ", meetingPlace=" + meetingPlace +
                '}';
    }
}
