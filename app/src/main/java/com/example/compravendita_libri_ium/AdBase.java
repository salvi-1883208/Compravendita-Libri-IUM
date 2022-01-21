package com.example.compravendita_libri_ium;

import android.media.Image;

import java.util.Arrays;

public class AdBase {
    private UsedBook book;
    private double price;
    private int[] photosId;
    private MeetingPlace meetingPlace;

    public AdBase(UsedBook book, double price, int[] photosId, MeetingPlace meetingPlace) {
        this.book = book;
        this.price = price;
        this.photosId = photosId;
        this.meetingPlace = meetingPlace;
    }

    public UsedBook getBook() {
        return book;
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

    @Override
    public String toString() {
        return book +
                "Prezzo: " + price + '€' +
                "\nPunto di incontro: " + meetingPlace;
    }
}
