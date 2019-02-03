package com.topclass.workbox.api;

import com.topclass.workbox.dto.User;
import com.topclass.workbox.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

// Controller : 클라와 Model을 주고 받음

@Slf4j
@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    // TODO 토큰 만드는 것도 추가해야함

    public UserController(final UserService userService) {this.userService = userService; }

//    @GetMapping("")
//    public ResponseEntity getUser(@RequestHeader(value = "Authorization") final Optional<String> token){
//        // 앞으로 user id는 token이라 지칭하겠음
//
//        // TODO token이 없는 경우 새로운 token을 만들어주는 부분 필요
////        return new ResponseEntity<>(calendarService.getCalendarTab(decodedToken.getUser_idx()), HttpStatus.OK);
//    }
//
//    @PostMapping("")
//    public ResponseEntity signUp(@RequestBody final User user){
//    }

    // 1. 유저 등록 (초기화면 – 학번확인 정도)  / POST
    @PostMapping
    public ResponseEntity createUser(@RequestParam(value = "student_id") final String student_id,
                                     @RequestParam(value = "password") final String password){
        String uuid = UUID.randomUUID().toString();
        User user = new User(uuid, student_id, password);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }
    // 2. 테마 설정 / PUT

}
