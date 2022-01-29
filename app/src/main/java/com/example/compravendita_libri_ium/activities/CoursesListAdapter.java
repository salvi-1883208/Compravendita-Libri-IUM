package com.example.compravendita_libri_ium.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.compravendita_libri_ium.Course;
import com.example.compravendita_libri_ium.R;

import java.util.ArrayList;

public class CoursesListAdapter extends ArrayAdapter<Course> {

    String[] courseNames = new String[3];

    //constuctor
    public CoursesListAdapter(Context context, ArrayList<Course> courseArrayList) {

        super(context, R.layout.activity_select_course_listitem, courseArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Course course = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_select_course_listitem, parent, false);
        }

        TextView courseName = convertView.findViewById(R.id.course_name);
        TextView numSuggestedBooks = convertView.findViewById(R.id.number_suggested_books);

        courseName.setText(course.getCourseName());
        numSuggestedBooks.setText(Integer.toString(course.getBooks().size()));

        return convertView;
    }
}
