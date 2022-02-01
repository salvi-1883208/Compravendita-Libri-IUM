package com.example.compravendita_libri_ium.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.Course;
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

        getSupportActionBar().setTitle("Libri suggeriti: " + course.getCourseName());
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