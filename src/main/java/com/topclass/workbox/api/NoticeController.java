package com.topclass.workbox.api;


import com.topclass.workbox.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(final NoticeService noticeService){
        this.noticeService = noticeService;
    }

    // Api 6 : 공지 리스트 불러오기
    @GetMapping("")
    public ResponseEntity getNotice(@RequestParam("user_id") final String user_id){
//        try{
//
//        }
//        catch (Exception e){
//
//        }
        return new ResponseEntity<>(noticeService.getAllNotice(user_id), HttpStatus.OK);
    }

    // Api 4 : 미확인 공지 개수 불러오기
    @GetMapping("")
    public ResponseEntity getUncheckedNoticeCount(@RequestParam("user_id") final String user_id){
//        try {
//
//        }
//        catch (Exception e){
//
//        }
        return new ResponseEntity<>(noticeService.getUncheckedNoticeCount(user_id), HttpStatus.OK);
    }
}
