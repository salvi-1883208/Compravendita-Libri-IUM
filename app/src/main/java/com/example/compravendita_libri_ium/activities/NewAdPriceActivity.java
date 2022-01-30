package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdPhotosBinding;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdPriceBinding;

public class NewAdPriceActivity extends AppCompatActivity {

    private ActivityNewAdPriceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdPriceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewAdBuilder builder = (NewAdBuilder) this.getIntent().getParcelableExtra("builder");

        if (builder.hasSubCondition())
            getSupportActionBar().setTitle("Passo 5: Prezzo");
        else
            getSupportActionBar().setTitle("Passo 4: Prezzo");
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