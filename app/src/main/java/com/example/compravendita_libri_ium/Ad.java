package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class Ad implements Parcelable, Comparable<Ad> {
    private boolean approved = false;
    private AdBase adBase;
    private Seller seller = null;

    public Ad(AdBase adBase, boolean approved) {
        this(adBase, null, approved);
    }

    public Ad(AdBase adBase, Seller seller, boolean approved) {
        this.adBase = adBase;
        this.approved = approved;
        this.seller = seller;
    }

    public AdBase getAdBase() {
        return adBase;
    }

    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        approved = true;
    }

    public Seller getSeller() {
        return seller;
    }

    public static Order toOrder(Ad ad) {
        return new Order(ad.getAdBase(), ad.getSeller());
    }

    @Override
    public String toString() {
        return adBase + "\nApprovato: " + approved + "\n" + (seller == null ? "" : seller.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Ad))
            return false;

        Ad ad = (Ad) o;

        return adBase.equals(ad.getAdBase()) &&
                (ad.isApproved() == isApproved());
    }

    @Override
    public int compareTo(Ad ad) {
        if (this.equals(ad))
            return 0;
        if (this.isApproved() && !ad.isApproved())
            return 1;
        return this.toString().compareToIgnoreCase(ad.toString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.approved ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.adBase, flags);
        dest.writeParcelable(this.seller, flags);
    }

    public void readFromParcel(Parcel source) {
        this.approved = source.readByte() != 0;
        this.adBase = source.readParcelable(AdBase.class.getClassLoader());
        this.seller = source.readParcelable(Seller.class.getClassLoader());
    }

    protected Ad(Parcel in) {
        this.approved = in.readByte() != 0;
        this.adBase = in.readParcelable(AdBase.class.getClassLoader());
        this.seller = in.readParcelable(Seller.class.getClassLoader());
    }

    public static final Creator<Ad> CREATOR = new Creator<Ad>() {
        @Override
        public Ad createFromParcel(Parcel source) {
            return new Ad(source);
        }

        @Override
        public Ad[] newArray(int size) {
            return new Ad[size];
        }
    };
}
