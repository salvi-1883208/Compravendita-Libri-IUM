package com.example.compravendita_libri_ium;

public enum Courses {
    ALGEBRA("Algebra"),
    FISICA("Fisica"),
    ALGORITMI("Algoritmi");

    private Course course;

    Courses(String courseName) {
        this.course = new Course(courseName);
    }

    public Course getCourse() {
        return course;
    }
}
