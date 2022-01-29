package com.example.compravendita_libri_ium;

import java.util.ArrayList;
import java.util.Arrays;

public enum Ads {
    FISICA_II_2008(new Ad(new AdBase(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_EVIDENZ))),
            30.0, new int[]{R.drawable.lezioni_di_fisica_ii_0, R.drawable.lezioni_di_fisica_ii_1}, MeetingPlace.FERMI), true)),
    FISICA_I_2008(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            35.0, new int[]{R.drawable.lezioni_di_fisica_front, R.drawable.lezioni_di_fisica_back}, MeetingPlace.FERMI), false));
    private Ad ad;

    Ads(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }
}

