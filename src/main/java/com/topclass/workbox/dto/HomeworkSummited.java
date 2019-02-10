package com.topclass.workbox.dto;

public class HomeworkSummited {
    private Homework homework;
    private HomeworkResult homeworkResult;

    public HomeworkSummited(Homework homework, HomeworkResult homeworkResult){
        this.homework = homework;
        this.homeworkResult = homeworkResult;
    }
}
