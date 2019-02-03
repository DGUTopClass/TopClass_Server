package com.topclass.workbox.service;

import com.topclass.workbox.mapper.UserMapper;
import com.topclass.workbox.model.DefaultRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(final UserMapper userMapper){
        this.userMapper = userMapper;
    }


}
