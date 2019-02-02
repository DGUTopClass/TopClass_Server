package com.topclass.workbox.api;

import com.topclass.workbox.service.HomeworkService;
import com.topclass.workbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/homework")
public class HomeworkController {
    private final HomeworkService homeworkService;
    // TODO 토큰 만드는 것도 추가해야함

    public HomeworkController(final HomeworkService homeworkService) {this.homeworkService = homeworkService; }

    public ResponseEntity getSummitedHomeworkList(@RequestHeader(value = "Authorization") final Optional<String> token){
        // 1. 받은 user의 id를 이용해
        // 2. decode해 user에 해당하는 idx를 받음
        Integer userIdx = 1;

        return new ResponseEntity<>(homeworkService.getUserHomework(userIdx, true), HttpStatus.OK);
//        return new ResponseEntity<>(calendarService.getCalendarTab(decodedToken.getUser_idx()), HttpStatus.OK);
    }
    
    public ResponseEntity getToBeSummitedHomeworkList(@RequestHeader(value = "Authorization") final Optional<String> token){
        // 1. 받은 user의 id를 이용해
        // 2. decode해 user에 해당하는 idx를 받음
        Integer userIdx = 1;

        return new ResponseEntity<>(homeworkService.getUserHomework(userIdx, false), HttpStatus.OK);
    }

}
