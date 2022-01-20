package com.example.compravendita_libri_ium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button button_ordini_eff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Sezione compravendita libri");

        button_ordini_eff = findViewById(R.id.button_ordini_eff);
        button_ordini_eff.setOnClickListener(view -> openOrdersList());
    }

    public void openOrdersList(){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }
}