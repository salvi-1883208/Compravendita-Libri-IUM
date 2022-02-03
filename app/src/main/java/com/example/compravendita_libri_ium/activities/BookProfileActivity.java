package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.compravendita_libri_ium.Book;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.Order;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.RecyclerItemClickListener;
import com.example.compravendita_libri_ium.RecyclerViewImageAdapter;
import com.example.compravendita_libri_ium.databinding.ActivityInfoOrderBinding;

public class BookProfileActivity extends AppCompatActivity {

    private ActivityInfoOrderBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO implementare lo zoom sulle immagini e aggiungere il pulsante per vedere la mappa
        super.onCreate(savedInstanceState);
        binding = ActivityInfoOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();

        if (intent != null) {

            Order order = (Order) intent.getParcelableExtra("order");

            RecyclerViewImageAdapter adapter = new RecyclerViewImageAdapter(this, order.getAdBase().getPhotos());
            binding.recyclerImages.setAdapter(adapter);
            binding.recyclerImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            binding.recyclerImages.addOnItemTouchListener(new RecyclerItemClickListener(this, binding.recyclerImages, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    //Toast.makeText(BookProfileActivity.this, "clicked on " +position, Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(BookProfileActivity.this, CLASSE_FATTA_APPOSTA_PER_MOSTRARE_IMMAGINE_BIG.class);
                    //startActivity(intent);
                }

                @Override
                public void onLongItemClick(View view, int position) {

                }
            }));

            binding.infoLibro.setText(order.getAdBase().getUsedBook().toString());
            binding.infoVenditore.setText(order.getSeller().toString());
            binding.ratingBar.setRating(order.getSeller().getReputation());
            binding.moreInfoLibro.setText(orderConditions(order));
            binding.meetingPlace.setText(order.getAdBase().getMeetingPlace().toString());
            binding.price.setText(order.getAdBase().getPriceString());
            binding.timeLeft.setText(timeLeft(order));

            getSupportActionBar().setTitle(order.getAdBase().getUsedBook().getTitle());
        }
    }

    private String orderConditions(Order order) {
        String s1 = order.getAdBase().getUsedBook().getCondition().getDescription();
        String s2 = "";
        for (BookSubCondition bookSubCondition : order.getAdBase().getUsedBook().getSubConditions()) {
            s2 += bookSubCondition.getDescription();
        }
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