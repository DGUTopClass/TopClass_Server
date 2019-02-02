package com.topclass.workbox.api;

import com.topclass.workbox.dto.User;
import com.topclass.workbox.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {this.userService = userService; }

    @GetMapping("")
    public ResponseEntity getUser(@RequestParam("id") final Optional<String> id){
        //
    }

    @PostMapping("")
    public ResponseEntity signUp(@RequestBody final User user){
        //
    }

}
