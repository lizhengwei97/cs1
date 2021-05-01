package com.cs.demo.controller;

import com.cs.demo.dto.BaseResponse;
import com.cs.demo.dto.PageDto;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.UserReqDto;
import com.cs.demo.dto.response.NoticeRespDto;
import com.cs.demo.service.NoticeService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 通知管理
 * @author:
 **/
@RestController
@RequestMapping("/api/v1/notice")
@Api(tags = "通知管理")
public class NoticeController extends BaseController {
    @Resource
    private NoticeService noticeService;

    @PostMapping("/page")
    public BaseResponse<PageResult<NoticeRespDto>> page(@RequestBody PageDto reqDto) {
        return new BaseResponse(noticeService.page(reqDto, getUserId()));
    }
}
