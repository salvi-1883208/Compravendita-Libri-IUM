package com.example.compravendita_libri_ium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewAdListAdapter extends ArrayAdapter<Book> {

    private ArrayList<Book> books;
    private Context context;
    private Filter filter;

    //constuctor
    public NewAdListAdapter(Context context, ArrayList<Book> bookArrayList) {
        super(context, R.layout.new_ad_item_list, bookArrayList);
        this.books = bookArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
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
        Button button = (Button) convertView.findViewById(R.id.new_ad_infos_button);
        button.setVisibility(View.GONE);
        bookEdition.setText("Edizione: " + Integer.toString(book.getEdition()));


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new AdapterFilter<Book>(books);
        return filter;
    }

    private class AdapterFilter<T> extends Filter {

        private ArrayList<T> sourceObjects;

        public AdapterFilter(ArrayList<T> objects) {
            sourceObjects = new ArrayList<T>();
            synchronized (this) {
                sourceObjects.addAll(objects);
            }
        }

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            String filterSeq = charSequence.toString().toLowerCase();
            FilterResults results = new FilterResults();
            if (filterSeq != null && filterSeq.length() > 0) {
                ArrayList<T> filter = new ArrayList<T>();

                for (T object : sourceObjects) {
                    if (object.toString().toLowerCase().contains(filterSeq))
                        filter.add(object);
                }
                results.count = filter.size();
                results.values = filter;
            } else {
                synchronized (this) {
                    results.values = sourceObjects;
                    results.count = sourceObjects.size();
                }
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            ArrayList<T> filtered = (ArrayList<T>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = filtered.size(); i < l; i++)
                add((Book) filtered.get(i));
            notifyDataSetInvalidated();
        }
    }
}