package com.example.compravendita_libri_ium;

public enum Ads {
    FISICA_II_2008(new Ad(new AdBase(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_EVIDENZ),
            30.0, new int[0], MeetingPlace.FERMI), true)),
    FISICA_I_2008(new Ad(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
            35.0, new int[] {R.drawable.lezioni_di_fisica_front}, MeetingPlace.FERMI), false));
    //R.drawable.lezioni_di_fisica_front
    private Ad ad;

    Ads(Ad ad) {
        this.ad = ad;
    }

    public Ad getAd() {
        return ad;
    }
}

