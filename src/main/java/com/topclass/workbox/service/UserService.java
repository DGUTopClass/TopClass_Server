package com.topclass.workbox.service;

import com.topclass.workbox.dto.User;
import com.topclass.workbox.mapper.UserMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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

    public DefaultRes updateTheme(final Integer theme){
        // controller에서 path에서 id로 주는데 그럼 여기서 필요없겟지?~?
        userMapper.updateTheme(theme);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.UPDATE_USER);
    }
}
