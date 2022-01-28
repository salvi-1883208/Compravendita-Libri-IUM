package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.compravendita_libri_ium.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("Sezione compravendita libri");

        binding.vendiLibri.setOnClickListener(view -> {
            Intent OpenVendita = new Intent(HomeActivity.this, NewAdActivity.class);
            startActivity(OpenVendita);
        });

        binding.compraLibri.setOnClickListener(view -> {

        });

        binding.ordiniEffettuati.setOnClickListener(view -> {
            Intent OpenOrdini = new Intent(HomeActivity.this, OrdersActivity.class);
            startActivity(OpenOrdini);
        });

        binding.annunciInseriti.setOnClickListener(view -> {
            Intent OpenAnnunci = new Intent(HomeActivity.this, AdsActivity.class);
            startActivity(OpenAnnunci);
        });
    }
}