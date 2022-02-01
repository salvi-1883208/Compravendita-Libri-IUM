package com.example.compravendita_libri_ium;

import java.util.ArrayList;
import java.util.Collections;

public class ActiveAds {

    private static ActiveAds instance = null;

    //Gli annunci che IO ho pubblicato
    private static ArrayList<Ad> myAds = new ArrayList<>();

    //Gli annunci dei quali poi posso fare un ordine
    private static ArrayList<Ad> ads = new ArrayList<>();

    private ActiveAds() {
        //Inizializzo i miei annunci
        for (MyAds ad : MyAds.values())
            myAds.add(ad.getAd());
        Collections.sort(myAds);

        //Inizializzo gli annunci degli altri utenti
        for (Ads ad : Ads.values())
            ads.add(ad.getAd());
    }

    public static ActiveAds getInstance() {
        if (instance == null)
            instance = new ActiveAds();
        return instance;
    }

    public static ArrayList<Ad> getMyAds() {
        return myAds;
    }

    public static void addMyAd(Ad ad) {
        myAds.add(0, ad);
    }

    public static boolean removeMyAd(Ad ad) {
        return myAds.remove(ad);
    }

    public static ArrayList<Ad> getAds() {
        return ads;
    }

}
