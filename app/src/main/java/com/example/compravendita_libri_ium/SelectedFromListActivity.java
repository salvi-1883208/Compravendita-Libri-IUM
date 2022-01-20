package com.example.compravendita_libri_ium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectedFromListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_from_list);

        Intent intent = getIntent();
        //Get the message sent from the previous window
        String selected = intent.getStringExtra("SELECTED");

        //Set the message to the displayed text
        TextView textView = findViewById(R.id.textSelected);
        textView.setText(selected);
    }
}