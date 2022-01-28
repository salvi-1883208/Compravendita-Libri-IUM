package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.compravendita_libri_ium.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Sezione compravendita libri");

        LinearLayout vendi_libro = findViewById(R.id.vendi_libri);
        vendi_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LinearLayout compra_libro = findViewById(R.id.compra_libri);
        compra_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LinearLayout ordini_effettuati = findViewById(R.id.ordini_effettuati);
        ordini_effettuati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OpenOrdini = new Intent(HomeActivity.this,OrdersActivity.class);
                startActivity(OpenOrdini);
            }
        });

        LinearLayout annunci_inseriti = findViewById(R.id.annunci_inseriti);
        annunci_inseriti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OpenAnnunci = new Intent(HomeActivity.this, AdsActivity.class);
                startActivity(OpenAnnunci);
            }
        });

    }
}