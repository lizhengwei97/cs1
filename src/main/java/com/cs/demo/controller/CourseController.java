package com.cs.demo.controller;

import com.cs.demo.dto.BaseResponse;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.CourseReqDto;
import com.cs.demo.dto.response.UserRespDto;
import com.cs.demo.service.CourseService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 课程管理
 * @author:
 **/
@RestController
@RequestMapping("/api/v1/course")
@Api(tags = "课程管理")
public class CourseController extends BaseController {
    @Resource
    private CourseService courseService;

    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody CourseReqDto reqDto) {
        courseService.add(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody CourseReqDto reqDto) {
        courseService.update(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }
//
//    @PostMapping("/del")
//    public BaseResponse<Boolean> del(@RequestBody UserReqDto reqDto) {
//        userService.delUser(reqDto, getUserInfo());
//        return new BaseResponse(Boolean.TRUE);
//    }

    @PostMapping("/page")
    public BaseResponse<PageResult<UserRespDto>> page(@RequestBody CourseReqDto reqDto) {
        return new BaseResponse(courseService.page(reqDto, getUserInfo()));
    }
}
