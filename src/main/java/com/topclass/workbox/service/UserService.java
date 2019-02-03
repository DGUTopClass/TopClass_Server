package com.topclass.workbox.service;

import com.topclass.workbox.dto.User;
import com.topclass.workbox.mapper.UserMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Status;
import javax.transaction.Transactional;

@Slf4j
@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(final UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Transactional
    public DefaultRes createUser(final User user){
        userMapper.insertUser(user);
        return DefaultRes.res(StatusCode.CREATED, ResponseMessage.CREATED_USER);
    }
}
