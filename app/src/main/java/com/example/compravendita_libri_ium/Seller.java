package com.example.compravendita_libri_ium;

import android.os.Parcel;
import android.os.Parcelable;

public class Seller implements Parcelable {

    private String name;
    private int id;
    private int reputation; //0, 1, 2, 3, 4, 5 stars

    public Seller(String name, int id, int reputation) {
        this.name = name;
        this.id = id;
        this.reputation = reputation;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public String toString() {
        return name + "\n" + id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Seller))
            return false;

        Seller seller = (Seller) o;

        return seller.getName().equalsIgnoreCase(name) &&
                seller.getId() == id &&
                seller.getReputation() == reputation;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.id);
        dest.writeInt(this.reputation);
    }

    public void readFromParcel(Parcel source) {
        this.name = source.readString();
        this.id = source.readInt();
        this.reputation = source.readInt();
    }

    protected Seller(Parcel in) {
        this.name = in.readString();
        this.id = in.readInt();
        this.reputation = in.readInt();
    }

    public static final Parcelable.Creator<Seller> CREATOR = new Parcelable.Creator<Seller>() {
        @Override
        public Seller createFromParcel(Parcel source) {
            return new Seller(source);
        }

        @Override
        public Seller[] newArray(int size) {
            return new Seller[size];
        }
    };
}
