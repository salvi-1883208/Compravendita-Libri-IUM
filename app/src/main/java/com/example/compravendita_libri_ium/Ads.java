package com.example.compravendita_libri_ium;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;

public enum Ads {
    FISICA_I_2008(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            35.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))), MeetingPlace.FERMI), false)),
    FISICA_II_2008(new Ad(new AdBase(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_EVIDENZ))),
            30.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_ii_0), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_ii_1))), MeetingPlace.FERMI), true));
    private Ad ad;

    Ads(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }

}
