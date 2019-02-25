package com.topclass.workbox.mapper;

import com.topclass.workbox.dto.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface NoticeMapper {

    // 어떤 회원의 모든 공지 리스트 가져오기
    @Select("SELECT * FROM NoticePersonal WHERE user_id = #{user_id}")
    List<Notice> getAllNotice(@Param("user_id") final String user_id);

    // 어떤 회원의 읽지 않은 공지 개수 가져오기
    @Select("SELECT * FROM NoticePersonal WHERE user_id = #{user_id} AND isChecked = 0")
    int getUncheckedNoticeCount(@Param("user_id") final String user_id);

}
