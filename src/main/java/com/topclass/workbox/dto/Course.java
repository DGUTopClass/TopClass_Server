package com.topclass.workbox.dto;

public class Course {
    private String id;
    private String title;

    public Course(String id){ this.id = id; }
    public Course(String id, String title){
        this.id = id;
        this.title = title;
    }
    public void setTitle(String title) {this.title = title;}
}
