package com.example.compravendita_libri_ium;

import java.util.ArrayList;

public class ActiveOrders {

    private static ActiveOrders instance = null;

    private static ArrayList<Order> orders = new ArrayList<>();

    private ActiveOrders() {
        for (Orders order : Orders.values())
            orders.add(order.getOrder());
    }

    public static ActiveOrders getInstance() {
        if (instance == null)
            instance = new ActiveOrders();
        return instance;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean removeOrder(Order order) {
        return orders.remove(order);
    }
}
