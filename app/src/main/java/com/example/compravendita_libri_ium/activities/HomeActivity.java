package com.example.compravendita_libri_ium.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Sezione compravendita libri");

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);//Night mode disabled

        binding.compraLibri.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, NewOrderCourseActivity.class);
            intent.putExtra("start", true);
            startActivity(intent);
        });

        binding.vendiLibri.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, NewAdActivity.class);
            intent.putExtra("builder", new NewAdBuilder(true));
            startActivity(intent);
        });

        binding.ordiniEffettuati.setOnClickListener(view -> {
            Intent OpenOrdini = new Intent(HomeActivity.this, OrdersActivity.class);
            startActivity(OpenOrdini);

            //startActivity(OpenOrdini, ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.slide_up_from_bottom, R.anim.slide_down_from_top).toBundle());
            overridePendingTransition(R.anim.slide_up_from_bottom, R.anim.slide_down_from_top);
        });

        binding.annunciInseriti.setOnClickListener(view -> {
            Intent OpenAnnunci = new Intent(HomeActivity.this, AdsActivity.class).addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(OpenAnnunci);
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
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}