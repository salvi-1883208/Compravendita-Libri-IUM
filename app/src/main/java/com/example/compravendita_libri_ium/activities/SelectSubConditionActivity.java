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

import com.example.compravendita_libri_ium.BookCondition;
import com.example.compravendita_libri_ium.BookSubCondition;
import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivitySelectSubConditionBinding;

import java.util.ArrayList;

public class SelectSubConditionActivity extends AppCompatActivity {

    private ActivitySelectSubConditionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectSubConditionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewAdBuilder builder = this.getIntent().getParcelableExtra("builder");

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 3: Condizioni specifiche");

        if (builder.getBookCondition() == BookCondition.BUONE_CONDIZIONI)
            buoneCondizioni(builder);
        else
            discreteCondizioni(builder);

        View.OnClickListener predicate = view -> {
            if (binding.continuaButton.getVisibility() == View.GONE)
                binding.continuaButton.setVisibility(View.VISIBLE);
            else if (!binding.checkBox1.isChecked() && !binding.checkBox2.isChecked() && !binding.checkBox3.isChecked())
                binding.continuaButton.setVisibility(View.GONE);
        };
        binding.checkBox1.setOnClickListener(predicate);
        binding.checkBox2.setOnClickListener(predicate);
        binding.checkBox3.setOnClickListener(predicate);

    }

    private void buoneCondizioni(NewAdBuilder builder) {
        binding.checkBox1.setText("Sottolineato a matita o penna");
        binding.checkBox3.setText("Sottolineato con evidenziatore");
        binding.checkBox2.setText("Pagine con pieghe");

        binding.continuaButton.setOnClickListener(view -> {
            ArrayList<BookSubCondition> subConditions = new ArrayList<>();
            if (binding.checkBox1.isChecked())
                subConditions.add(BookSubCondition.SOTT_MATITA_O_PENNA);
            if (binding.checkBox2.isChecked())
                subConditions.add(BookSubCondition.PAGINE_PIEGHE);
            if (binding.checkBox3.isChecked())
                subConditions.add(BookSubCondition.SOTT_EVIDENZ);

            builder.setSubCondition(subConditions);
            Intent intent = new Intent(SelectSubConditionActivity.this, NewAdPhotosActivity.class);
            intent.putExtra("builder", builder);
            startActivity(intent);
        });
    }

    private void discreteCondizioni(NewAdBuilder builder) {
        binding.checkBox1.setText("Evidenziato indelebilmente");
        binding.checkBox3.setText("Appunti scritti sulle pagine");
        binding.checkBox2.setText("Pagine rovinate");

        binding.continuaButton.setOnClickListener(view -> {
            ArrayList<BookSubCondition> subConditions = new ArrayList<>();
            if (binding.checkBox1.isChecked())
                subConditions.add(BookSubCondition.EVIDENZ_INDELEB);
            if (binding.checkBox2.isChecked())
                subConditions.add(BookSubCondition.PAGINE_ROVINATE);
            if (binding.checkBox3.isChecked())
                subConditions.add(BookSubCondition.APPUNTI_SU_PAGINE);

            builder.setSubCondition(subConditions);
            Intent intent = new Intent(SelectSubConditionActivity.this, NewAdPhotosActivity.class);
            intent.putExtra("builder", builder);
            startActivity(intent);
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