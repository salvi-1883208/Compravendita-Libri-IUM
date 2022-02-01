package com.example.compravendita_libri_ium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewOrderBookForCourseListAdapter extends ArrayAdapter<AdsBook> {
    public NewOrderBookForCourseListAdapter(@NonNull Context context, @NonNull ArrayList<AdsBook> objects) {
        super(context, R.layout.new_order_item_books_course_list, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AdsBook adsBook = getItem(position);
        if (convertView == null)         //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_order_item_books_course_list, parent, false);

        TextView bookName = convertView.findViewById(R.id.new_order_book_title);
        TextView bookEdition = convertView.findViewById(R.id.new_order_book_edition);
        TextView disponibility = convertView.findViewById(R.id.view_disponibility);
        if (adsBook.getDisponibility() > 0) {
            disponibility.setVisibility(View.VISIBLE);
            disponibility.setText("disponibilità: " + adsBook.getDisponibility());
        } else
            convertView.findViewById(R.id.view_non_disponibile_2).setVisibility(View.VISIBLE);

        bookName.setText(adsBook.getBook().getTitle());
        bookEdition.setText("Edizione: " + Integer.toString(adsBook.getBook().getEdition()));

        return convertView;
    }
}
