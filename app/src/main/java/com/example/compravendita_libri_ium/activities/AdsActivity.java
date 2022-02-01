package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.MyActiveAds;
import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.AdsListAdapter;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityOrdersOrAdsBinding;

import java.util.ArrayList;

public class AdsActivity extends AppCompatActivity {

    private ActivityOrdersOrAdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("Annunci Inseriti");

        binding = ActivityOrdersOrAdsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Una lista con tutti gli annunci da mostrare
        ArrayList<Ad> adsArrayList = MyActiveAds.getInstance().getAds();

        AdsListAdapter adsListAdapter = new AdsListAdapter(AdsActivity.this, adsArrayList);
        binding.listview.setAdapter(adsListAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(AdsActivity.this, AdProfileActivity.class);
            intent.putExtra("ad", adsArrayList.get(position));
            startActivity(intent);

        });

        binding.newOrderOrAd.setOnClickListener(view -> {
            Intent intent = new Intent(AdsActivity.this, NewAdActivity.class);
            intent.putExtra("builder", new NewAdBuilder(false));
            startActivity(intent);
        });
    }

    @Override
    public void onRestart() {
        super.onRestart();
        //Do what you want on the refresh procedure here
        finish();
        startActivity(getIntent());
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