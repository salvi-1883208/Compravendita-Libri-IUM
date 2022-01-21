package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    private int timeRemaining = 10080; //In minutes
    private boolean completed = false;
    private Seller seller;
    private AdBase adBase;

    public Order(AdBase adBase, Seller seller) {
        this.seller = seller;
        this.adBase = adBase;
    }

    public Seller getSeller() {
        return seller;
    }

    public AdBase getAdBase() {
        return adBase;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void complete() {
        completed = true;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.timeRemaining);
        dest.writeByte(this.completed ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.seller, flags);
        dest.writeParcelable(this.adBase, flags);
    }

    public void readFromParcel(Parcel source) {
        this.timeRemaining = source.readInt();
        this.completed = source.readByte() != 0;
        this.seller = source.readParcelable(Seller.class.getClassLoader());
        this.adBase = source.readParcelable(AdBase.class.getClassLoader());
    }

    protected Order(Parcel in) {
        this.timeRemaining = in.readInt();
        this.completed = in.readByte() != 0;
        this.seller = in.readParcelable(Seller.class.getClassLoader());
        this.adBase = in.readParcelable(AdBase.class.getClassLoader());
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
