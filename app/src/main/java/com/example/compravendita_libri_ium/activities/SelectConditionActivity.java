package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdBinding;
import com.example.compravendita_libri_ium.databinding.ActivitySelectConditionBinding;

public class SelectConditionActivity extends AppCompatActivity {

    private ActivitySelectConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectConditionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Passo 2: Condizioni libro");

//        binding.condizioniRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                binding.continuaButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent = new Intent(SelectConditionActivity.this, );
//                    }
//                });
//            }
//        });
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