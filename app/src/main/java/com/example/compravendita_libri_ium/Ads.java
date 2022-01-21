package com.example.compravendita_libri_ium;

public enum Ads {
    FISICA_II_2008(new Ad(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_EVIDENZ),
            30.0, new int[0], MeetingPlace.FERMI)),
    FISICA_I_2008(new Ad(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
                    35.0, new int[R.drawable.lezioni_di_fisica_front], MeetingPlace.FERMI)),
    ALGORITMI_STR_DAT(new Ad(Books.ALGORITMI_STR_DAT.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
            35.0, new int[0], MeetingPlace.FERMI))
    ;

    private Ad ad;

    Ads(Ad ad) {
        this.ad = ad;
    }

    }
