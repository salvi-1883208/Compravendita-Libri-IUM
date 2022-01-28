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

        if (intent != null) {

            Order order = (Order) intent.getParcelableExtra("order");

            RecyclerViewImageAdapter adapter = new RecyclerViewImageAdapter(this, order.getAdBase().getPhotos());
            binding.recyclerImages.setAdapter(adapter);
            binding.recyclerImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            binding.infoLibro.setText(order.getAdBase().getUsedBook().toString());
            binding.infoVenditore.setText(order.getSeller().toString());
            binding.ratingBar.setRating(order.getSeller().getReputation());
            binding.moreInfoLibro.setText(orderConditions(order));
            binding.meetingPlace.setText(order.getAdBase().getMeetingPlace().toString());
            binding.price.setText(Double.toString(order.getAdBase().getPrice()) + "€");
            binding.timeLeft.setText(timeLeft(order));

            getSupportActionBar().setTitle(order.getAdBase().getUsedBook().getTitle());
        }
    }

    private String orderConditions(Order order) {
        String s1 = order.getAdBase().getUsedBook().getCondition().getDescription();
        String s2 = order.getAdBase().getUsedBook().getSubCondition().getDescription();
        if (s2 == null)
            return s1;
        return s1 + "\n" + s2;
    }

    private String timeLeft(Order order) {
        if (order.isCompleted())
            return "Ordine Completato";
        return "Libro riservato ancora per: " + minutesToString(order.getTimeRemaining());
    }

    private String minutesToString(int t) {
        int hours = t / 60;
        int minutes = t % 60;
        if (hours > 24)
            return (hours / 24) == 1 ? (hours / 24) + " giorno" : (hours / 24) + " giorni";
        return (hours + ":" + minutes);
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