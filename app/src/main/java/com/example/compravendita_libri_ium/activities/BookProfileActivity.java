package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerViewImageAdapter;
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

            RecyclerView recyclerView = findViewById(R.id.recycler_images);

            RecyclerViewImageAdapter adapter = new RecyclerViewImageAdapter(this, order.getAdBase().getPhotos());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            binding.titleProfile.setText(order.getAdBase().getBook().toString());
            //binding.bookProfilePhoto.setImageResource(order.getAdBase().getPhotos()[0]);

            getSupportActionBar().setTitle(order.getAdBase().getBook().getTitle());

        }
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