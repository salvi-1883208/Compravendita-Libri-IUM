package com.example.compravendita_libri_ium;

public enum Orders {
    ALGORITMI_STR_DAT(new Order(new AdBase(Books.ALGORITMI_STR_DAT.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
            35.0, new int[0], MeetingPlace.DARWIN), new Seller("Maurizio Bianchi"))),
    ELEMENTI_FISICA(new Order(new AdBase(Books.ELEMENTI_FISICA.getBook().toUsedBook(BookCondition.DISCRETE_CONDIZIONI, BookSubCondition.SOTT_MATITA_O_PENNA),
            25.0, new int[0], MeetingPlace.DARWIN), new Seller("Maurizio Bianchi")));

    private Order order;

    Orders(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}