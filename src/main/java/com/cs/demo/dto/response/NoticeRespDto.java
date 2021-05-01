package com.cs.demo.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author
 * @description: 通知
 **/
@Data
public class NoticeRespDto implements Serializable {
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;

    private Date createTime;
}
