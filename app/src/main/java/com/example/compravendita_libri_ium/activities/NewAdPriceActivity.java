package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.NewAdBuilder;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewAdPriceBinding;

public class NewAdPriceActivity extends AppCompatActivity {

    private ActivityNewAdPriceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewAdPriceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NewAdBuilder builder = this.getIntent().getParcelableExtra("builder");

        binding.newAdPriceInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.setPriceContinuaButton.getVisibility() == View.GONE)
                    binding.setPriceContinuaButton.setVisibility(View.VISIBLE);
                else if (binding.newAdPriceInput.getText().toString().isEmpty())
                    binding.setPriceContinuaButton.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        binding.setPriceContinuaButton.setOnClickListener(view -> {
            Intent intent = new Intent(NewAdPriceActivity.this, NewAdMeetingPlaceActivity.class);
            intent.putExtra("builder", builder.setPrice(Double.parseDouble(binding.newAdPriceInput.getText().toString())));
            startActivity(intent);
        });

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);

        if (builder.hasSubCondition())
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 5: Prezzo");
        else
            ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Passo 4: Prezzo");
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