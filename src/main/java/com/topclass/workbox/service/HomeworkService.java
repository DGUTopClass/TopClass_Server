package com.topclass.workbox.service;

import com.topclass.workbox.dto.Homework;
import com.topclass.workbox.mapper.CourseMapper;
import com.topclass.workbox.mapper.HomeworkMapper;
import com.topclass.workbox.mapper.SubjectMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeworkService {
    private HomeworkMapper homeworkMapper;

    private CourseMapper courseMapper;
    private SubjectMapper subjectMapper;

    public HomeworkService(final HomeworkMapper homeworkMapper, final CourseMapper courseMapper, final SubjectMapper subjectMapper){
        this.homeworkMapper = homeworkMapper;
        this.courseMapper = courseMapper;
        this.subjectMapper = subjectMapper;
    }

    // 제출예정 과제 목록 받아오기
    public DefaultRes getToBeSummitedHomeworkList(String userId){
        List<String> courseIdList = courseMapper.selectCourseId(userId);

        List<Homework> homeworkList = new ArrayList<Homework>();
        for(String courseId : courseIdList){
            homeworkList.addAll(homeworkMapper.selectHomework(courseId));
            homeworkList.addAll(homeworkMapper.selectHomeworkPersonal(courseId, userId));
        }

        // subject_id를 subject_title로 변환
        for(Homework homework : homeworkList){
            // 오늘날짜와 비교해서 지난건지, 아닌지 확인
            if(isPast(homework.getFinishDate())) homeworkList.remove(homework);
            else homework.setSubjectId(subjectMapper.getTitleOfSubject(homework.getSubjectId()));
        }

        // 정렬기준에 따라 정렬도 해야함!!
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_HOMEWORK, homeworkList);
    }

    // 제출기간 만료 과제 목록 받아오기
    public DefaultRes getSummitedHomeworkList(String userId){
        List<String> courseIdList = courseMapper.selectCourseId(userId);

        List<Homework> homeworkList = new ArrayList<Homework>();
        for(String courseId : courseIdList){
            homeworkList.addAll(homeworkMapper.selectHomework(courseId));
            homeworkList.addAll(homeworkMapper.selectHomeworkPersonal(courseId, userId));
        }

        //  HW result도 받아옴 >> 데이터를 추가적으로 List에 반영해줌
        //  따라서, 지금은 howework로 해뒀는데 새로운 데이터 타입(hw을 상속 받은)이 필요

        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_HOMEWORK, homeworkList);
    }

    boolean isPast(String finishDate){
        SimpleDateFormat currentDate = new SimpleDateFormat ("yyyy-MM-dd");
        Date time = new Date();

        String current = currentDate.format(time);

        if(current.compareTo(finishDate) > 0) return true;
        else return false;
    }
}
