package com.example.compravendita_libri_ium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button button_vendi_libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Sezione compravendita libri");

        button_vendi_libro = findViewById(R.id.button_vendi_libro);
        button_vendi_libro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrdersList();
            }
        });
    }

    public void openOrdersList(){
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }
}