package com.topclass.workbox.mapper;

import com.topclass.workbox.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User(id, student_id, password, theme) VALUES(#{user.id}, #{user.student_id}, #{user.password}, #{user.theme})")
    void insertUser(@Param("user") final User user);
}
