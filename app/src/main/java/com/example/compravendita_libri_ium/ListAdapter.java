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

public class ListAdapter extends ArrayAdapter<Book> {

    //constuctor
    public ListAdapter(Context context, ArrayList<Book> bookArrayList){

        super(context, R.layout.orders_listitem, bookArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book book = getItem(position);
        if(convertView == null){        //???

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.orders_listitem, parent, false);

        }

        ImageView imageView = convertView.findViewById(R.id.book_photo);
        //TextView bookTitle = convertView.findViewById(getItemId(book.title));       ///???https://youtu.be/RHqGiWluAzU?t=565
        //TextView bookAuthor = convertView.findViewById(R.id.);


        return super.getView(position, convertView, parent);
    }
}
