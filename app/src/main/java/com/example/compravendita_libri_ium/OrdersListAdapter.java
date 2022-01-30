package com.example.compravendita_libri_ium;

import static android.graphics.Color.rgb;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OrdersListAdapter extends ArrayAdapter<Order> {

    //constuctor
    public OrdersListAdapter(Context context, ArrayList<Order> ordersArrayList) {

        super(context, R.layout.orders_listitem, ordersArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Order order = getItem(position);
        if (convertView == null) {        //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orders_listitem, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.book_photo);
        TextView bookTitle = convertView.findViewById(R.id.book_title);       ///???https://youtu.be/RHqGiWluAzU?t=565
        TextView bookEditionPrice = convertView.findViewById(R.id.book_infos);
        TextView orders_expiring_time = convertView.findViewById(R.id.order_expire_countdown);

        imageView.setImageURI(order.getAdBase().getPhotos().get(0));
        bookTitle.setText(order.getAdBase().getUsedBook().getTitle());
        bookEditionPrice.setText(editionPriceInfo(order));
        if (order.isCompleted()) {
            orders_expiring_time.setText("Ordine Completato");
            orders_expiring_time.setTypeface(null, Typeface.BOLD);
        } else
            orders_expiring_time.setText(minutesToString(order.getTimeRemaining()));

        return convertView;
    }

    private String editionPriceInfo(Order order) {
        String edition = Integer.toString(order.getAdBase().getUsedBook().getEdition());
        String price = order.getAdBase().getPriceString();
        return "Edizione: " + edition + "\nPrezzo: " + price;
    }

    private String minutesToString(int t) {
        int hours = t / 60;
        int minutes = t % 60;
        if (hours > 24)
            return (hours / 24) + " giorni rimanenti";
        return (hours + ":" + minutes + " left");
    }
}
