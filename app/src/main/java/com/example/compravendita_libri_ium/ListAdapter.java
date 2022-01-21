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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Order> {

    //constuctor
    public ListAdapter(Context context, ArrayList<Order> ordersArrayList){

        super(context, R.layout.orders_listitem, ordersArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Order order = getItem(position);
        if(convertView == null){        //???

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orders_listitem, parent, false);

        }

        ImageView imageView = convertView.findViewById(R.id.book_photo);
        TextView bookTitle = convertView.findViewById(R.id.book_title);       ///???https://youtu.be/RHqGiWluAzU?t=565
        TextView bookAuthor = convertView.findViewById(R.id.book_infos);
        TextView orders_expiring_time = convertView.findViewById(R.id.order_expire_countdown);

        //imageView.setImageResource(ad.getPhotos()[0]);
        bookTitle.setText(order.getAdBase().getBook().getTitle());
        bookAuthor.setText(order.getAdBase().getBook().getAuthor());
        orders_expiring_time.setText(order.getTimeRemaining());

        //imageView.setImageResource(ad.getPhotos()[0]);
        bookTitle.setText(order.getAdBase().getBook().getTitle());
        bookAuthor.setText(order.getAdBase().getBook().getAuthor());
        orders_expiring_time.setText(order.getTimeRemaining());

        return convertView;
    }
}
