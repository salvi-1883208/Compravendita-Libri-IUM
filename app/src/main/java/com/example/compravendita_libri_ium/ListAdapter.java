package com.example.compravendita_libri_ium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Order> {

    //constuctor
    public ListAdapter(Context context, ArrayList<Order> ordersArrayList) {

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
        TextView bookAuthor = convertView.findViewById(R.id.book_infos);
        TextView orders_expiring_time = convertView.findViewById(R.id.order_expire_countdown);

        imageView.setImageResource(order.getAdBase().getPhotos()[0]);
        bookTitle.setText(order.getAdBase().getBook().getTitle());
        bookAuthor.setText(order.getAdBase().getBook().getAuthor());
        orders_expiring_time.setText(minutesToString(order.getTimeRemaining()));

        return convertView;
    }

    private String minutesToString(int t) {
        int hours = t / 60;
        int minutes = t % 60;
        if (hours > 24)
            return (hours / 24) + " giorni rimanenti";
        return (hours + ":" + minutes + " left");
    }
}
