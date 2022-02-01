package com.example.compravendita_libri_ium.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.compravendita_libri_ium.Course;
import com.example.compravendita_libri_ium.Courses;
import com.example.compravendita_libri_ium.NewOrderCourseListAdapter;
import com.example.compravendita_libri_ium.R;
import com.example.compravendita_libri_ium.databinding.ActivityNewOrderCourseBinding;

import java.util.ArrayList;

public class NewOrderCourseActivity extends AppCompatActivity {

    private ActivityNewOrderCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOrderCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Ricerca libro tramite corso");
        ArrayList<Course> courses = new ArrayList<>();

        for (Courses course : Courses.values())
            courses.add(course.getCourse());

        NewOrderCourseListAdapter adapter = new NewOrderCourseListAdapter(this, courses);
        binding.cursesListview.setAdapter(adapter);

        binding.cursesListview.setOnItemClickListener((adapterView, view, position, l) -> {
            if (courses.get(position).getAvailableBooks() > 0) {
                Intent intent = new Intent(NewOrderCourseActivity.this, NewOrderBooksForCourseActivity.class);
                intent.putExtra("start", this.getIntent().getBooleanExtra("start", true));
                intent.putExtra("course", courses.get(position));
                startActivity(intent);
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