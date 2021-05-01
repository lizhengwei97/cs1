package com.cs.demo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhanghao
 * @Date: 2021/4/18 0018 下午 20:30
 */
@Data
public class PageDto implements Serializable {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 分页条数
     */
    private Integer pageSize;
}
