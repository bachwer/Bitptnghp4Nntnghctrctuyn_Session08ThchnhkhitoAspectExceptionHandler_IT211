package org.example.ex4.entity;


public class Course {

    private Long id;
    private String title;

    public Course() {
    }

    public Course(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}