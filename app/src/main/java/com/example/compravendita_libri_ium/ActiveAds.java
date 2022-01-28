package com.example.compravendita_libri_ium;

import java.util.ArrayList;

public class ActiveAds {

    private static ActiveAds instance = null;

    private static ArrayList<Ad> ads = new ArrayList<>();

    private ActiveAds() {
        for (Ads ad : Ads.values())
            ads.add(ad.getAd());
    }

    public static ActiveAds getInstance() {
        if (instance == null)
            instance = new ActiveAds();
        return instance;
    }

    public ArrayList<Ad> getAds() {
        return ads;
    }

    public void addAd(Ad ad) {
        ads.add(ad);
    }

    public boolean removeAd(Ad ad) {
        return ads.remove(ad);
    }
}
