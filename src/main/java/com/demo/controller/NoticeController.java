package com.demo.controller;

import com.demo.exception.ResultBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @RequestMapping("/getNotice")
    public ResultBody getNotice(HttpServletRequest request,
                                @RequestParam("noticeStatus")String noticeStatus){
        return ResultBody.success(null);
    }
}
