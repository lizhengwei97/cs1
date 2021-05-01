package com.cs.demo.service;

import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.CourseReqDto;
import com.cs.demo.dto.response.CourseRespDto;
import com.cs.demo.eo.UserEo;

/**
 * @Author:
 */
public interface CourseService {
    void add(CourseReqDto reqDto, UserEo userEo);

    void update(CourseReqDto reqDto, UserEo currUser);

    PageResult<CourseRespDto> page(CourseReqDto reqDto, UserEo currUser);

}
