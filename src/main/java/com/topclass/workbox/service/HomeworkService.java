package com.topclass.workbox.service;

import com.topclass.workbox.dto.Homework;
import com.topclass.workbox.mapper.HomeworkMapper;
import com.topclass.workbox.model.DefaultRes;

import java.util.List;

public class HomeworkService {
    private HomeworkMapper homeworkMapper;

    public HomeworkService(final HomeworkMapper homeworkMapper){
        this.homeworkMapper = homeworkMapper;
    }

    // 유저별 과제리스트 get //
    public DefaultRes getUserHomework(Integer userIdx){
        List<Homework>  homeworkList
    }
}
