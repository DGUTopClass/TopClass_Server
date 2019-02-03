package com.topclass.workbox.dto;

public class User {
    private String id;
    private String student_id;
    private String password;
    private int theme;

    public User(String id, String student_id, String password){
        this.id = id;
        this.student_id = student_id;
        this.password = password;

        this.theme = 0; // default !
    }

    public void setId(String id) {this.id = id;}
    public void setStudentId(String student_id) {this.student_id = student_id;}
    public void setPassword(String password) {this.password = password;}
    public void setTheme(Integer theme) {this.theme = theme;}
}
