package com.topclass.workbox.api;


import com.topclass.workbox.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(final NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping("")
    public ResponseEntity getNotice(@RequestParam("id"))
        //뭘 보내줘야 그 사람이 듣는 모든 과목의 공지사항을 띄울 수 있을까?
}
