package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class Ad implements Parcelable {
    private boolean approved = false;
    private AdBase adBase;

    public Ad(AdBase adBase, boolean approved) {
        this.adBase = adBase;
        this.approved = approved;
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

    @Override
    public String toString() {
        return adBase + "\nApprovato: " + approved + "\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.approved ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.adBase, flags);
    }

    public void readFromParcel(Parcel source) {
        this.approved = source.readByte() != 0;
        this.adBase = source.readParcelable(AdBase.class.getClassLoader());
    }

    protected Ad(Parcel in) {
        this.approved = in.readByte() != 0;
        this.adBase = in.readParcelable(AdBase.class.getClassLoader());
    }

    public static final Parcelable.Creator<Ad> CREATOR = new Parcelable.Creator<Ad>() {
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
