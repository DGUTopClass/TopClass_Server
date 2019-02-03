package com.topclass.workbox.service;

import com.topclass.workbox.mapper.CourseMapper;
import com.topclass.workbox.mapper.SubjectMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private CourseMapper courseMapper;
    private SubjectMapper subjectMapper;

    public CourseService(CourseMapper courseMapper, SubjectMapper subjectMapper){
        this.courseMapper = courseMapper;
        this.subjectMapper = subjectMapper;
    }

    public DefaultRes getCourseList(String userId){
        // token == user_id
        // 이를 이용해 과목(과목에 해당 하는 id)들을 받음
        List<String> courseIdList = courseMapper.getCourseId(userId);
        // 이걸 돌면서 Subject title을 가져

        List<Course> courseList = new ArrayList<Course>();
        for(String courseId : courseIdList){
            courseList.add(new Course(courseId, subjectMapper.getTitleOfSubject(courseId)));
        }

        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_COURSE, courseList);
    }
}
