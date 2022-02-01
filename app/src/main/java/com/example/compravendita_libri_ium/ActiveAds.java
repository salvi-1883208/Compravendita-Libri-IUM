package com.example.compravendita_libri_ium;

import java.util.ArrayList;
import java.util.Collections;

public class ActiveAds {

    private static ActiveAds instance = null;

    private static ArrayList<Ad> ads = new ArrayList<>();

    private ActiveAds() {
        for (Ads ad : Ads.values())
            ads.add(ad.getAd());
        sort();
    }


    public static ActiveAds getInstance() {
        if (instance == null)
            instance = new ActiveAds();
        return instance;
    }

    public static ArrayList<Ad> getAds() {
        return ads;
    }

    public static void addAd(Ad ad) {
        ads.add(0, ad);
    }

    public static boolean removeAd(Ad ad) {
        return ads.remove(ad);
    }

    private static void sort() {
        Collections.sort(ads);
    }
}
