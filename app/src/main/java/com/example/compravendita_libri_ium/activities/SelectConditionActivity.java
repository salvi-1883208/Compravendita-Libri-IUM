package com.example.compravendita_libri_ium.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.compravendita_libri_ium.BookCondition;
import com.example.compravendita_libri_ium.NewAdBuilder;
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

        NewAdBuilder builder = (NewAdBuilder) this.getIntent().getParcelableExtra("builder");

        binding.condizioniRadioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            Intent intent;
            switch (i) {
                case R.id.come_nuovo_button: {   //libro come nuovo
                    intent = new Intent(SelectConditionActivity.this, NewAdPhotosActivity.class);
                    intent.putExtra("builder", builder.setCondition(BookCondition.COME_NUOVO));
                    break;
                }
                case R.id.buone_condizioni_button: {   //buone condizioni
                    intent = new Intent(SelectConditionActivity.this, SelectSubConditionActivity.class);
                    intent.putExtra("builder", builder.setCondition(BookCondition.BUONE_CONDIZIONI));
                    break;
                }
                case R.id.discrete_condizioni_button: {   //discrete condizioni
                    intent = new Intent(SelectConditionActivity.this, SelectSubConditionActivity.class);
                    intent.putExtra("builder", builder.setCondition(BookCondition.DISCRETE_CONDIZIONI));
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + i);
            }

            if (binding.continuaButton.getVisibility() == View.GONE)
                binding.continuaButton.setVisibility(View.VISIBLE);

            binding.continuaButton.setOnClickListener(view -> startActivity(intent));
        });
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