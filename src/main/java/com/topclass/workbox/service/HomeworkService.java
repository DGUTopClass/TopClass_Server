package com.topclass.workbox.service;

import com.topclass.workbox.dto.Homework;
import com.topclass.workbox.mapper.CourseMapper;
import com.topclass.workbox.mapper.HomeworkMapper;
import com.topclass.workbox.mapper.SubjectMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;

import java.util.ArrayList;
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
            homework.setSubjectId(subjectMapper.getTitleOfSubject(homework.getSubjectId()));
        }

        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_HOMEWORK, homeworkList);
    }

    // 제출기간 만료 과제 목록 받아오기
    public DefaultRes getSummitedHomeworkList(String userId){
        // 왜 int로 userIdx를 받아올깡 ? ~ ?

        // 1. user가 수강중인 모든 과목의 id를 받아옴
        List<String> courseIdList = courseMapper.selectCourseId(userId);
        // 2. 각 과목 id를 돌며 간단한 포맷의 hw 데이터를 받아옴
        List<Homework> homeworkList = new ArrayList<Homework>();
        for(String courseId : courseIdList){
            homeworkList.addAll(homeworkMapper.selectHomework(courseId));
        }

        // 3. 사용자의 탭에 따라 isHanded가 true 혹은 false 인것만 선별

        // 3-2. if isHanded == true >> HW result도 받아옴 >> 데이터를 추가적으로 List에 반영해줌
                                                        // 따라서, 지금은 howework로 해뒀는데 새로운 데이터 타입(hw을 상속 받은)이 필요
        // 4. DefaultRes를 하나 만들어서 이를 리턴
        // ex) DefaultRes.res(StatusCode.OK, ResponseMessage.READ_SUCCESS, calendarTabReqList);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_HOMEWORK, homeworkList);
    }
}
