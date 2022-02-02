package com.example.compravendita_libri_ium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewOrderAdsListAdapter extends ArrayAdapter<Ad> {
    public NewOrderAdsListAdapter(@NonNull Context context, @NonNull ArrayList<Ad> objects) {
        super(context, R.layout.new_order_item_ads_book, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Ad ad = this.getItem(position);

        System.out.println("\n" + ad + "\n");
        if (convertView == null)         //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_order_item_ads_book, parent, false);

        TextView seller = convertView.findViewById(R.id.new_order_book_seller);
        TextView conditionAndPrice = convertView.findViewById(R.id.new_order_book_condition_price);
        RatingBar ratingBar = convertView.findViewById(R.id.new_order_rating_bar);

        seller.setText(ad.getSeller().getName());
        ratingBar.setRating(ad.getSeller().getReputation());
        conditionAndPrice.setText(conditionAndPrice(ad));


        return convertView;
    }

    private String conditionAndPrice(Ad ad) {
        return adConditions(ad) + "\nPrezzo: " + ad.getAdBase().getPriceString();
    }

    private String adConditions(Ad ad) {
        String s1 = ad.getAdBase().getUsedBook().getCondition().getDescription().replace(" usato ma", "");
        s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1);
        String s2 = "";
        for (BookSubCondition bookSubCondition : ad.getAdBase().getUsedBook().getSubConditions()) {
            s2 += "\n" + bookSubCondition.getDescription();
        }
        if (s2 == null)
            return s1;
        return s1 + s2;
    }
}