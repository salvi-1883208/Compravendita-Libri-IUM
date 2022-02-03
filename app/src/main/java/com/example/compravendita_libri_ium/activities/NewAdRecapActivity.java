package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.ActiveAds;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdRecapBinding;

public class NewAdRecapActivity extends AppCompatActivity {

    private ActivityNewAdRecapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdRecapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Riepilogo annuncio");

        NewAdBuilder builder = this.getIntent().getParcelableExtra("builder");

        binding.newAdInfoLibro.setText(builder.getBook().toString());
        binding.newAdMoreInfoLibro.setText(bookConditions(builder));
        binding.newAdPrice.setText(priceToString(builder.getPrice()));
        binding.newAdMeetingPlace.setText(builder.getMeetingPlace().getDescription());

        binding.recapFinishButton.setOnClickListener(view -> {
            ActiveAds.addMyAd(builder.build());

            Intent intent;
            if (builder.getStart()) {
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                Toast.makeText(getApplicationContext(), "Annuncio inserito correttamente", Toast.LENGTH_LONG).show();
            } else {
                intent = new Intent(getApplicationContext(), AdsActivity.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }

    private String priceToString(double price) {
        return price % 1 == 0 ? Math.round(price) + "€" : price + "€";
    }

    private String bookConditions(NewAdBuilder builder) {
        String s1 = builder.getBookCondition().getDescription();
        String s2 = "";
        for (BookSubCondition bookSubCondition : builder.getBookSubCondition()) {
            s2 += "\n" + bookSubCondition.getDescription();
        }
        if (s2 == null)
            return s1;
        return s1 + s2;
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