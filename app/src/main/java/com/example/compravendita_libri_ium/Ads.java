package com.example.compravendita_libri_ium;

public enum Ads {
    //TODO fix with new Ad class
    FISICA_II_2008(new AdBase(Books.FISICA_II_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_EVIDENZ),
            30.0, new int[0], MeetingPlace.FERMI)),
    FISICA_I_2008(new AdBase(Books.FISICA_I_2008.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
                    35.0, new int[R.drawable.lezioni_di_fisica_front], MeetingPlace.FERMI)),
    ALGORITMI_STR_DAT(new AdBase(Books.ALGORITMI_STR_DAT.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
            35.0, new int[0], MeetingPlace.FERMI))
    ;

    private AdBase adBase;

    Ads(AdBase adBase) {
        this.adBase = adBase;
    }

    }
