package com.example.compravendita_libri_ium;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;

public enum MyOrders {
    ALGORITMI_STR_DAT(new Order(new AdBase(Books.ALGORITMI_STR_DAT.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<BookSubCondition>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            35.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.algoritmi_e_strutture_dati_0), AdBase.drawableToUri(R.drawable.algoritmi_e_strutture_dati_1))), MeetingPlace.DARWIN), Sellers.MAURIZIO_BIANCHI.getSeller())),
    ELEMENTI_FISICA(new Order(new AdBase(Books.ELEMENTI_FISICA.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, new ArrayList<BookSubCondition>(Arrays.asList(BookSubCondition.SOTT_MATITA_O_PENNA))),
            25.0, new ArrayList<Uri>(Arrays.asList(AdBase.drawableToUri(R.drawable.elementi_di_fisica_0), AdBase.drawableToUri(R.drawable.elementi_di_fisica_1))), MeetingPlace.DARWIN), Sellers.MAURIZIO_BIANCHI.getSeller()).complete());

    private Order order;

    MyOrders(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
