package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerViewImageAdapter;
import com.example.compravendita_libri_ium.databinding.ActivityNewOrderAdDetailsBinding;

public class NewOrderAdDetailsActivity extends AppCompatActivity {

    private ActivityNewOrderAdDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOrderAdDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Dettagli libro");

        Ad ad = this.getIntent().getParcelableExtra("ad");

        binding.recyclerImages.setAdapter(new RecyclerViewImageAdapter(this, ad.getAdBase().getPhotos()));
        binding.recyclerImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        binding.infoLibro.setText(ad.getAdBase().getUsedBook().toString());
        binding.infoVenditore.setText(ad.getSeller().toString());
        binding.ratingBar.setRating(ad.getSeller().getReputation());
        binding.moreInfoLibro.setText(adConditions(ad));
        binding.price.setText(ad.getAdBase().getPriceString());
        binding.meetingPlace.setText(ad.getAdBase().getMeetingPlace().toString());
        binding.newOrderAcquistaButton.setText("Acquista ora: " + ad.getAdBase().getPriceString());
        binding.newOrderAcquistaButton.setOnClickListener(view -> {
            Intent intent = new Intent(NewOrderAdDetailsActivity.this, MeetingPlaceMapActivity.class);
            intent.putExtra("start", this.getIntent().getBooleanExtra("start", true));
            intent.putExtra("ad", ad);
            startActivity(intent);
        });
    }

    private String adConditions(Ad ad) {
        String s1 = ad.getAdBase().getUsedBook().getCondition().getDescription();
        String s2 = "";
        for (BookSubCondition bookSubCondition : ad.getAdBase().getUsedBook().getSubConditions()) {
            s2 += bookSubCondition.getDescription();
        }
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