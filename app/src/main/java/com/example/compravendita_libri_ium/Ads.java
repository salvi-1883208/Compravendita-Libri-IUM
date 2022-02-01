package com.example.compravendita_libri_ium;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;

public enum Ads {
    A(new Ad(new AdBase(Books.ANALISI_MAT.getBook().toUsedBook(BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            30.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.analisi_matematica))), MeetingPlace.FERMI), Sellers.MATTEO_ROSSI.getSeller(), true)),
    B(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            30.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))), MeetingPlace.FERMI), Sellers.MATTEO_ROSSI.getSeller(), true)),
    C(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.APPUNTI_SU_PAGINE))),
            25.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))), MeetingPlace.FERMI), Sellers.MATTEO_BIANCHI.getSeller(), true)),
    D(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.APPUNTI_SU_PAGINE))),
            25.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))), MeetingPlace.FERMI), Sellers.LORENZO_VERDI.getSeller(), true)),
    E(new Ad(new AdBase(Books.FISICA_I_2011.getBook().toUsedBook(BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_EVIDENZ))),
            25.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))), MeetingPlace.FERMI), Sellers.NICOLA_GALLI.getSeller(), true));

    private Ad ad;

    Ads(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }
}
