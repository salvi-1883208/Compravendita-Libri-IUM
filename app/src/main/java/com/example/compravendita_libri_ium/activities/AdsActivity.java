package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.AdBase;
import com.example.compravendita_libri_ium.Ads;
import com.example.compravendita_libri_ium.AdsListAdapter;
import com.example.compravendita_libri_ium.BookCondition;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.Books;
import com.example.compravendita_libri_ium.MeetingPlace;
import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.Orders;
import com.example.compravendita_libri_ium.OrdersListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class AdsActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Annunci Inseriti");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Ad> adsArrayList = new ArrayList<>();

        //Riempio una lista con tutti gli annunci da mostrare
        for (Ads ad : Ads.values()) {
            adsArrayList.add(ad.getAd());
        }

        AdsListAdapter adsListAdapter = new AdsListAdapter(AdsActivity.this, adsArrayList);
        binding.listview.setAdapter(adsListAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AdsActivity.this, AdProfileActivity.class);
                intent.putExtra("ad", adsArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        menu.clear();
        inflater.inflate(R.menu.close_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.close_button:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}