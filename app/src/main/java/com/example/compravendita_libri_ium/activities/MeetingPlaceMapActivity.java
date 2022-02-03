package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.Ad;
import com.example.compravendita_libri_ium.Courses;
import com.example.compravendita_libri_ium.MyActiveOrders;
import com.example.compravendita_libri_ium.databinding.ActivityMeetingPlaceMapBinding;

public class MeetingPlaceMapActivity extends AppCompatActivity {

    private ActivityMeetingPlaceMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMeetingPlaceMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Mappa punto d'incontro");

        Ad ad = this.getIntent().getParcelableExtra("ad");

        switch (ad.getAdBase().getMeetingPlace()) {
            case DARWIN:
                binding.darwinLayout.setVisibility(View.VISIBLE);
                break;
            case FERMI:
                binding.fermiLayout.setVisibility(View.VISIBLE);
                break;
            case MINERVA:
                binding.minervaLayout.setVisibility(View.VISIBLE);
                break;
        }

        binding.meetingPlaceContinuaButton.setOnClickListener(view -> {
            Intent intent;
            if (this.getIntent().getBooleanExtra("start", true)) {
                intent = new Intent(getApplicationContext(), HomeActivity.class);
                Toast.makeText(getApplicationContext(), "Libro ordinato", Toast.LENGTH_LONG).show();
            }
            else
                intent = new Intent(getApplicationContext(), OrdersActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            MyActiveOrders.getInstance().addOrder(Ad.toOrder(ad));
            for (Courses courses : Courses.values())
                courses.removeAd(ad);
            startActivity(intent);
        });
    }
}