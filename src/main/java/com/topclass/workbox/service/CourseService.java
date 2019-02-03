package com.topclass.workbox.service;

import com.topclass.workbox.mapper.CourseMapper;
import com.topclass.workbox.model.DefaultRes;

import java.util.List;

public class CourseService {
    private CourseMapper courseMapper;

    public DefaultRes getCourseList(String userId){
        // token == user_id
        // 이를 이용해 과목(과목에 해당 하는 id)들을 받음
        List<String> courseIdList = courseMapper.getCourseId(userId);
        // 이걸 돌면서 Subject title을 가져
        
    }
}
