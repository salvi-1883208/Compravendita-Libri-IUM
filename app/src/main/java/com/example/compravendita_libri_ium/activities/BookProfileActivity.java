package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.databinding.ActivityInfoOrderBinding;

public class BookProfileActivity extends AppCompatActivity {

    private ActivityInfoOrderBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if(intent != null){

            Order order = (Order)intent.getParcelableExtra("order");

            binding.titleProfile.setText(order.getAdBase().getBook().toString());
            binding.bookProfilePhoto.setImageResource(order.getAdBase().getPhotos()[0]);

            getSupportActionBar().setTitle(order.getAdBase().getBook().getTitle());

        }
    }
}