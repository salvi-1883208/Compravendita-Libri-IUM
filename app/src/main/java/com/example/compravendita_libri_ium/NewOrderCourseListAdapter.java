package com.example.compravendita_libri_ium;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NewOrderCourseListAdapter extends ArrayAdapter<Course> {
    public NewOrderCourseListAdapter(@NonNull Context context, @NonNull ArrayList<Course> objects) {
        super(context, R.layout.new_order_item_courses_list, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Course course = getItem(position);
        if (convertView == null)         //???
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.new_order_item_courses_list, parent, false);

        TextView courseName = convertView.findViewById(R.id.new_order_course_title);
        TextView suggestedBooksNumber = convertView.findViewById(R.id.new_order_suggested_number);
        if (course.getAvailableBooks() > 0)
            convertView.findViewById(R.id.view_acquista).setVisibility(View.VISIBLE);
        else
            convertView.findViewById(R.id.view_non_disponibile).setVisibility(View.VISIBLE);

        courseName.setText(course.getCourseName());
        suggestedBooksNumber.setText(course.getSuggestedBooks() +
                (course.getSuggestedBooks() == 1 ? " libro suggerito" : " libri suggeriti"));

        return convertView;
    }
}
