package com.topclass.workbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("SELECT id FROM Course WHERE user_id = #{user_id}")
    List<String> selectCourseId(@Param("user_id") final String user_id);
}
