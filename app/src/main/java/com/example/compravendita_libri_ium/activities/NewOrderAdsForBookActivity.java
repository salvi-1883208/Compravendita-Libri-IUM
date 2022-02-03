package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.AdsBook;
import com.example.compravendita_libri_ium.NewOrderAdsListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewOrderAdsForBookBinding;

public class NewOrderAdsForBookActivity extends AppCompatActivity {

    private ActivityNewOrderAdsForBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOrderAdsForBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdsBook adsBook = this.getIntent().getParcelableExtra("adsBook");

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText(adsBook.getBook().getTitle());

        //getSupportActionBar().setSubtitle("Edizione: " + adsBook.getBook().getEdition());

        binding.adsListview.setAdapter(new NewOrderAdsListAdapter(this, adsBook.getAds()));

        binding.adsListview.setOnItemClickListener((adapterView, view, position, l) -> {
            Intent intent = new Intent(NewOrderAdsForBookActivity.this, NewOrderAdDetailsActivity.class);
            intent.putExtra("start", this.getIntent().getBooleanExtra("start", true));
            intent.putExtra("ad", adsBook.getAds().get(position));
            startActivity(intent);
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