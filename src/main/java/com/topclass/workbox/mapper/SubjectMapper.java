package com.topclass.workbox.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubjectMapper {
    @Select("SELECT title FROM Subject WHERE id = #{subject_id}")
    String getTitleOfSubject(@Param("subject_id") final String subject_id);
}
