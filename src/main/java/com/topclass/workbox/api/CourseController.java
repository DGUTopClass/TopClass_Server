package com.topclass.workbox.api;

import com.topclass.workbox.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("api/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(final CourseService courseService) {this.courseService = courseService;}

    public ResponseEntity getCourseList(@RequestHeader(value = "Authorization") final Optional<String> token){
        // 1. 받은 token을 이용해
        // 2. decode
        return new ResponseEntity<>(courseService.getCourseList("temp"), HttpStatus.OK);
    }
}
