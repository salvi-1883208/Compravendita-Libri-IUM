package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.MeetingPlace;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdMeetingPlaceBinding;

public class NewAdMeetingPlaceActivity extends AppCompatActivity {

    private ActivityNewAdMeetingPlaceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdMeetingPlaceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewAdBuilder builder = this.getIntent().getParcelableExtra("builder");

        binding.meetingPlaceContinuaButton.setOnClickListener(view -> {
            Intent intent = new Intent(NewAdMeetingPlaceActivity.this, NewAdRecapActivity.class);
            if (binding.minervaText.getVisibility() == View.VISIBLE)
                builder.setMeetingPlace(MeetingPlace.MINERVA);
            else if (binding.darwinText.getVisibility() == View.VISIBLE)
                builder.setMeetingPlace(MeetingPlace.DARWIN);
            else if (binding.fermiText.getVisibility() == View.VISIBLE)
                builder.setMeetingPlace(MeetingPlace.FERMI);

            intent.putExtra("builder", builder);
            startActivity(intent);
        });

        binding.darwinButton.setOnClickListener(view -> {
            binding.fermiText.setVisibility(View.INVISIBLE);
            binding.minervaText.setVisibility(View.INVISIBLE);
            if (binding.darwinText.getVisibility() == View.INVISIBLE) {
                binding.darwinText.setVisibility(View.VISIBLE);
                if (binding.meetingPlaceContinuaButton.getVisibility() == View.GONE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.VISIBLE);
                else if (binding.fermiText.getVisibility() == View.VISIBLE ||
                        binding.minervaText.getVisibility() == View.VISIBLE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            } else {
                binding.darwinText.setVisibility(View.INVISIBLE);
                binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            }
        });

        binding.fermiButton.setOnClickListener(view -> {
            binding.minervaText.setVisibility(View.INVISIBLE);
            binding.darwinText.setVisibility(View.INVISIBLE);
            if (binding.fermiText.getVisibility() == View.INVISIBLE) {
                binding.fermiText.setVisibility(View.VISIBLE);
                if (binding.meetingPlaceContinuaButton.getVisibility() == View.GONE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.VISIBLE);
                else if (binding.darwinText.getVisibility() == View.VISIBLE ||
                        binding.minervaText.getVisibility() == View.VISIBLE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            } else {
                binding.fermiText.setVisibility(View.INVISIBLE);
                binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            }
        });

        binding.minervaButton.setOnClickListener(view -> {
            binding.fermiText.setVisibility(View.INVISIBLE);
            binding.darwinText.setVisibility(View.INVISIBLE);

            if (binding.minervaText.getVisibility() == View.INVISIBLE) {
                binding.minervaText.setVisibility(View.VISIBLE);
                if (binding.meetingPlaceContinuaButton.getVisibility() == View.GONE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.VISIBLE);
                else if (binding.fermiText.getVisibility() == View.VISIBLE ||
                        binding.darwinText.getVisibility() == View.VISIBLE)
                    binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            } else {
                binding.minervaText.setVisibility(View.INVISIBLE);
                binding.meetingPlaceContinuaButton.setVisibility(View.GONE);
            }
        });
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);

        if (builder.hasSubCondition())
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 6: Punto d'incontro");
        else
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 5: Punto d'incontro");
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