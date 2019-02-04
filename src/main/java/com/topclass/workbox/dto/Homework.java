package com.topclass.workbox.dto;

public class Homework {
    private String id; // hw 고유의 id > 이걸 전달해서 디테일뷰를 얻게
    private String title;
    private String subject_id;
    private String finish_date;

    public Homework(String id, String title, String subject_id, String finish_date){
        this.id = id;
        this.title = title;
        this.subject_id = subject_id;
        this.finish_date = finish_date;
    }

    public String getSubjectId(){ return subject_id; }
    public String getFinishDate() {return finish_date; }
    public void setSubjectId(String subjectTitle){
        this.subject_id = subjectTitle;
    }
}
