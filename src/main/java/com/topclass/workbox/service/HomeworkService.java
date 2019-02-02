package com.topclass.workbox.service;

import com.topclass.workbox.dto.Homework;
import com.topclass.workbox.mapper.HomeworkMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;

import java.util.List;

public class HomeworkService {
    private HomeworkMapper homeworkMapper;

    public HomeworkService(final HomeworkMapper homeworkMapper){
        this.homeworkMapper = homeworkMapper;
    }

    // 유저별 과제리스트 get //
    public DefaultRes getUserHomework(Integer userIdx, Boolean isHanded){
        // 1. user가 수강중인 모든 과목의 id를 받아옴

        // 2. 각 과목 id를 돌며 간단한 포맷의 hw 데이터를 받아옴
        // ex) "1"은 공개소프트웨어의 id 값
        List<Homework>  homeworkList = homeworkMapper.getSimpleFormatHomework("1");

        // 3. 사용자의 탭에 따라 isHanded가 true 혹은 false 인것만 선별

        // 3-2. if isHanded == true >> HW result도 받아옴 >> 데이터를 추가적으로 List에 반영해줌
                                                        // 따라서, 지금은 howework로 해뒀는데 새로운 데이터 타입(hw을 상속 받은)이 필요
        // 4. DefaultRes를 하나 만들어서 이를 리턴
        // ex) DefaultRes.res(StatusCode.OK, ResponseMessage.READ_SUCCESS, calendarTabReqList);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_HOMEWORK);
    }
}
