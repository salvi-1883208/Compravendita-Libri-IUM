package com.example.compravendita_libri_ium;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;

public enum Ads {
    A(Books.ANALISI_MAT.getBook(), BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA)), 30.0,
            new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.analisi_matematica))), MeetingPlace.FERMI, Sellers.MATTEO_ROSSI.getSeller()),

    B(Books.FISICA_I_2008.getBook(), BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA)), 30.0,
            new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))),
            MeetingPlace.FERMI, Sellers.MATTEO_ROSSI.getSeller()),

    C(Books.FISICA_I_2008.getBook(), BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.APPUNTI_SU_PAGINE)), 25.0,
            new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))),
            MeetingPlace.FERMI, Sellers.MATTEO_BIANCHI.getSeller()),

    D(Books.FISICA_I_2008.getBook(), BookCondition.DISCRETE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.APPUNTI_SU_PAGINE)), 25.0,
            new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back)))
            , MeetingPlace.FERMI, Sellers.LORENZO_VERDI.getSeller()),

    E(Books.FISICA_I_2011.getBook(), BookCondition.BUONE_CONDIZIONI, new ArrayList<>(Arrays.asList(BookSubCondition.SOTT_EVIDENZ)), 25.0,
            new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.lezioni_di_fisica_front), AdBase.drawableToUri(R.drawable.lezioni_di_fisica_back))),
            MeetingPlace.FERMI, Sellers.NICOLA_GALLI.getSeller());

    private Ad ad;

    Ads(Book book, BookCondition bookCondition, ArrayList<BookSubCondition> bookSubConditions, double price, ArrayList<Uri> photos, MeetingPlace meetingPlace, Seller seller) {
        this.ad = new Ad(new AdBase(book.toUsedBook(bookCondition, bookSubConditions), price, photos, meetingPlace), seller, true);
    }

    public Ad getAd() {
        return ad;
    }
}
