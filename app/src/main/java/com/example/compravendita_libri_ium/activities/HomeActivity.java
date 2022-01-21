package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.compravendita_libri_ium.R;

public class HomeActivity extends AppCompatActivity {
    private Button button_ordini_eff;
    private Button button_annunci_ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Sezione compravendita libri");

       // button_ordini_eff = findViewById(R.id.button_ordini_eff);
        //button_ordini_eff.setOnClickListener(view -> openOrdersList());

        //button_annunci_ins = findViewById(R.id.button_annunci_ins);
       // button_annunci_ins.setOnClickListener(view -> openAdsList());
    }

    private void openOrdersList(){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }

    private void openAdsList() {
        Intent intent = new Intent(this, AdsActivity.class);
        startActivity(intent);
    }
}