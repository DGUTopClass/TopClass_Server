package com.topclass.workbox.service;

import com.topclass.workbox.dto.Notice;
import com.topclass.workbox.dto.User;
import com.topclass.workbox.mapper.NoticeMapper;
import com.topclass.workbox.mapper.UserMapper;
import com.topclass.workbox.model.DefaultRes;
import com.topclass.workbox.utils.ResponseMessage;
import com.topclass.workbox.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.format.DecimalStyle;
import java.util.List;

@Slf4j
@Service
public class NoticeService {

    private final NoticeMapper noticeMapper;

    // 왜 빨간 줄 뜨지...서정스꺼는 user에만 뜨는데 뭐지뭐지 물어봐야겟당
    public NoticeService(final NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    public DefaultRes getAllNotice(final String user_id){
        final List<Notice> noticeList = noticeMapper.getAllNotice(user_id);
        if(noticeList.isEmpty()){
            return DefaultRes.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_NOTICE);
        }
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_NOTICE, noticeList);
    }

    public DefaultRes getUncheckedNoticeCount(final String user_id){
        int uncheckedNoticeCount = noticeMapper.getUncheckedNoticeCount(user_id);
        return DefaultRes.res(StatusCode.OK, ResponseMessage.READ_UNCHECKED_NOTICE_COUNT,uncheckedNoticeCount);
    }
}
