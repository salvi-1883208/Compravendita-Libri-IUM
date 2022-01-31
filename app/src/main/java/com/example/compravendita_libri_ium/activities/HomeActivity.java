package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

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
        getSupportActionBar().setTitle("Sezione compravendita libri");

        binding.compraLibri.setOnClickListener(view -> {
//            Intent intent = new Intent(HomeActivity.this, SelectCourseActivity.class);
//            startActivity(intent);
        });

        binding.vendiLibri.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, NewAdActivity.class);
            intent.putExtra("builder", new NewAdBuilder(true));
            startActivity(intent);
        });

        binding.ordiniEffettuati.setOnClickListener(view -> {
            Intent OpenOrdini = new Intent(HomeActivity.this, OrdersActivity.class);
            startActivity(OpenOrdini);
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