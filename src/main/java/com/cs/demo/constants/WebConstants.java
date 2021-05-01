package com.cs.demo.constants;

/**
 * @author
 * @description: 常量
 **/
public class WebConstants {
    /**
     * 默认页码，开始0
     */
    public static Integer DEFAULT_PAGE_NUMBER = 1;

    /**
     * 默认每页条数
     */
    public static Integer DEFAULT_PAGE_SIZE = 10;

    /**
     * 超级管理员角色
     */
    public static Long ADMIN_ROLE_ID = 1L;

    /**
     * 课程老师角色
     */
    public static Long TEACHER_ROLE_ID = 3L;
    /**
     * 最大课时数据
     */
    public static int MAX_COURSE_TIME = 20;

    public static Byte DR_NO = new Byte("0");

    public static Byte DR_YES = new Byte("1");

    /**
     * Head 签名 参数名
     */
    public static final String REQUEST_HEADER_ACCESS_TOKEN = "admin_token";
}
