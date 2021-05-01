package com.cs.demo.service;

import com.cs.demo.dto.PageDto;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.response.NoticeRespDto;

/**
 * @description: 通知服务
 * @author: mingren
 * @data: 2021/4/24 21:57
 **/
public interface NoticeService {

    PageResult<NoticeRespDto> page(PageDto dto, Long userId);
}
