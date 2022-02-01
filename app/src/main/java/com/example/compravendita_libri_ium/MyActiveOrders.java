package com.example.compravendita_libri_ium;

import java.util.ArrayList;

public class MyActiveOrders {

    private static MyActiveOrders instance = null;

    private static ArrayList<Order> orders = new ArrayList<>();

    private MyActiveOrders() {
        for (Orders order : Orders.values())
            orders.add(order.getOrder());
    }

    public static MyActiveOrders getInstance() {
        if (instance == null)
            instance = new MyActiveOrders();
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
