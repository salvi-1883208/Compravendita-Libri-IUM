package com.example.compravendita_libri_ium;

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

public class AdsListAdapter extends ArrayAdapter<Ad> {
    //constuctor
    public AdsListAdapter(Context context, ArrayList<Ad> adsArrayList) {

        super(context, R.layout.ads_listitem, adsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Ad ad = getItem(position);
        if (convertView == null) {        //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.ads_listitem, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.ads_book_photo);
        TextView bookTitle = convertView.findViewById(R.id.ads_book_title);       ///???https://youtu.be/RHqGiWluAzU?t=565
        TextView bookEditionPrice = convertView.findViewById(R.id.ads_book_infos);
        TextView adApprovation = convertView.findViewById(R.id.ads_approvation);

        imageView.setImageResource(ad.getAdBase().getPhotos()[0]);
        bookTitle.setText(ad.getAdBase().getUsedBook().getTitle());
        bookEditionPrice.setText(editionPriceInfo(ad));

        if (ad.isApproved())
            adApprovation.setText("Annuncio approvato");
        else
            adApprovation.setText("In attesa di approvazione");

        return convertView;
    }

    private String editionPriceInfo(Ad ad) {
        String edition = Integer.toString(ad.getAdBase().getUsedBook().getEdition());
        String price = ad.getAdBase().getPriceString();
        return "Edizione: " + edition + "\nPrezzo: " + price;
    }
}
