package com.topclass.workbox.dto;

public class HomeworkSummited {
    private Homework homework;
    private String feedback;
    private String score;

    public HomeworkSummited(Homework homework, String feedback, String score){
        this.homework = homework;
        this.feedback = feedback;
        this.score = score;
    }
}
