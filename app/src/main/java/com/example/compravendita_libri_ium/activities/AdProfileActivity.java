package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerViewImageAdapter;
import com.example.compravendita_libri_ium.databinding.ActivityAdProfileBinding;

public class AdProfileActivity extends AppCompatActivity {

    private ActivityAdProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {
            Ad ad = (Ad) intent.getParcelableExtra("ad");

            RecyclerView recyclerView = findViewById(R.id.ad_recycler_images);

            RecyclerViewImageAdapter adapter = new RecyclerViewImageAdapter(this, ad.getAdBase().getPhotos());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            binding.adInfoLibro.setText(ad.getAdBase().getUsedBook().toString());
            binding.adMoreInfoLibro.setText(adConditions(ad));
            binding.adMeetingPlace.setText(ad.getAdBase().getMeetingPlace().toString());
            binding.adPrice.setText(ad.getAdBase().getPriceString());
            binding.approvation.setText(approvation(ad));

            getSupportActionBar().setTitle(ad.getAdBase().getUsedBook().getTitle());

        }
    }

    private String approvation(Ad ad) {
        if (ad.isApproved())
            return "Annuncio approvato";
        return "Annuncio in attesa di approvazione";
    }

    private String adConditions(Ad ad) {
        String s1 = ad.getAdBase().getUsedBook().getCondition().getDescription();
        String s2 = ad.getAdBase().getUsedBook().getSubCondition().getDescription();
        if (s2 == null)
            return s1;
        return s1 + "\n" + s2;
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