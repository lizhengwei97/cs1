package com.cs.demo.dto.request;

import com.cs.demo.dto.PageDto;
import lombok.Data;

/**
 * @author
 * @description: 课程
 **/
@Data
public class CourseReqDto extends PageDto {

    private Long id;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 用户编码
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 学期
     */
    private String semester;

    /**
     * 课时
     */
    private Integer courseTimes;

    /**
     * 学生数
     */
    private Integer stuCount;

    /**
     * 签证
     */
    private String visa;
}
