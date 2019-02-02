package com.topclass.workbox.mapper;

import com.topclass.workbox.dto.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    @Select("SELECT id, title, finish_date FROM Homework WHERE subject_id = #{subject_id}")
    List<Homework> getSimpleFormatHomework(@Param("subject_id") final String subject_id);
}
