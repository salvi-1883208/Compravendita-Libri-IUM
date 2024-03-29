package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.Course;
import com.example.compravendita_libri_ium.NewOrderBookForCourseListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewOrderBooksForCourseBinding;

public class NewOrderBooksForCourseActivity extends AppCompatActivity {

    private ActivityNewOrderBooksForCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOrderBooksForCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Course course = this.getIntent().getParcelableExtra("course");

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_tool_bar);
        ((TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title)).setText("Libri suggeriti: " + course.getCourseName());

        //TODO cambiare l'ordine per far vedere prima quelli con disponibilità?
        NewOrderBookForCourseListAdapter adapter = new NewOrderBookForCourseListAdapter(this, course.getAdsBook());
        binding.cursesListview.setAdapter(adapter);

        binding.cursesListview.setOnItemClickListener((adapterView, view, position, l) -> {
            Button button = view.findViewById(R.id.new_orderd_buy_button);
            TextView infos = view.findViewById(R.id.new_order_book_edition);
            TextView disponibility = view.findViewById(R.id.view_disponibility);
            TextView notDisponible = view.findViewById(R.id.view_non_disponibile_2);

            button.setOnClickListener(view1 -> {
                Intent intent = new Intent(NewOrderBooksForCourseActivity.this, NewOrderAdsForBookActivity.class);
                intent.putExtra("start", NewOrderBooksForCourseActivity.this.getIntent().getBooleanExtra("start", true));
                intent.putExtra("adsBook", course.getAdsBook().get(position));
                startActivity(intent);
            });

            if (course.getAdsBook().get(position).getDisponibility() > 0) {
                if (button.getVisibility() == View.GONE) {
                    disponibility.setVisibility(View.GONE);
                    notDisponible.setVisibility(View.GONE);
                    infos.setText(course.getAdsBook().get(position).getBook().getDescription());
                    button.setVisibility(View.VISIBLE);
                } else {
                    button.setVisibility(View.GONE);
                    infos.setText("Edizione: " + course.getAdsBook().get(position).getBook().getEdition());
                    disponibility.setVisibility(View.VISIBLE);
                    disponibility.setText("disponibilità: " + course.getAdsBook().get(position).getDisponibility());
                }
            }
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