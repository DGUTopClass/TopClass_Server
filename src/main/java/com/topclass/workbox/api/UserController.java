package com.topclass.workbox.api;

import com.topclass.workbox.dto.User;
import com.topclass.workbox.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Controller : 클라와 Model을 주고 받음

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
//
//    }

}
