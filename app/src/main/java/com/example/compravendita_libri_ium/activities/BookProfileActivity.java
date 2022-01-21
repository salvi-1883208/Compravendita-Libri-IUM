package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.databinding.ActivityInfoOrderBinding;

public class BookProfileActivity extends AppCompatActivity {

    ActivityInfoOrderBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){

            String title = intent.getStringExtra("title");        //praticamente gli passi quello che hai messo a putExtra nel primo argomento
            String author = intent.getStringExtra("author");
            String publisher = intent.getStringExtra("publisher");
            String isbn = intent.getStringExtra("isbn");
            String subject = intent.getStringExtra("subject");
            String condition = intent.getStringExtra("condition");
            String sub_condition = intent.getStringExtra("sub condition");
            String price = intent.getStringExtra("price");
            String meeting_place = intent.getStringExtra("meeting place");
            String seller = intent.getStringExtra("seller");
            Integer time_remaining = intent.getIntExtra("time remaining", 0);

            binding.titleProfile.setText(title);
            //QUA VANNO BINDATE TUTTI I PEZZI DELLA SCHERMATA DELL'ORDINE E POI METTERCI I VALORI SCRITTI SOPRA^^^^^^
            //https://youtu.be/RHqGiWluAzU?t=1074

        }
    }
}
