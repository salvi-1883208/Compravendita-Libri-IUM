package com.example.compravendita_libri_ium;

import java.util.ArrayList;

public class Course {
    private ArrayList<Book> books;
    private String courseName;

    public Course(ArrayList<Book> books, String courseName){
        this.books = books;
        this.courseName = courseName;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getCourseName() {
        return courseName;
    }

}
