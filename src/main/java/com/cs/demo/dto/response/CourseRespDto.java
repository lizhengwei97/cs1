package com.cs.demo.dto.response;

import com.cs.demo.dto.PageDto;
import lombok.Data;

import java.util.Date;

/**
 * @author
 * @description: 课程
 **/
@Data
public class CourseRespDto extends PageDto {

    private Long id;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 学期
     */
    private String semester;
    /**
     * 用户编码
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
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

    private Date updateTime;
}
