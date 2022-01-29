package com.example.compravendita_libri_ium;


import java.util.ArrayList;
import java.util.Arrays;

public enum Courses {
    ALGEBRA(new Course(new ArrayList<Book>(Arrays.asList(Books.ANALISI_MAT.getBook())), "ALGEBRA")),
    FISICA(new Course(new ArrayList<Book>(Arrays.asList(Books.ELEMENTI_FISICA.getBook(), Books.FISICA_I_2008.getBook(), Books.FISICA_I_2011.getBook(), Books.FISICA_II_2008.getBook(), Books.FISICA_II_2011.getBook())), "FISICA")),
    ALGORITMI(new Course(new ArrayList<Book>(Arrays.asList(Books.ALGORITMI_STR_DAT.getBook())), "ALGORITMI"));

    private Course course;

    Courses(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}
