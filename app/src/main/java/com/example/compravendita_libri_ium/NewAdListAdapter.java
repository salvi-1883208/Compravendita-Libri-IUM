package com.example.compravendita_libri_ium;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.compravendita_libri_ium.activities.NewAdActivity;
import com.example.compravendita_libri_ium.activities.SelectConditionActivity;

import java.util.ArrayList;

public class NewAdListAdapter extends ArrayAdapter<Book> {

    //constuctor
    public NewAdListAdapter(Context context, ArrayList<Book> bookArrayList) {
        super(context, R.layout.new_ad_item_list, bookArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Book book = getItem(position);
        if (convertView == null) {        //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_ad_item_list, parent, false);
        }
        TextView bookTitle = convertView.findViewById(R.id.new_ad_book_title);
        TextView bookEdition = convertView.findViewById(R.id.new_ad_book_infos);

        bookTitle.setText(book.getTitle());
        bookEdition.setText("Edizione: " + Integer.toString(book.getEdition()));


        return convertView;
    }
}