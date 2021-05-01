package com.cs.demo.service.impl;

import com.cs.demo.constants.WebConstants;
import com.cs.demo.dto.PageDto;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.response.NoticeRespDto;
import com.cs.demo.eo.NoticeEo;
import com.cs.demo.eo.NoticeEoExample;
import com.cs.demo.mapper.NoticeEoMapper;
import com.cs.demo.service.NoticeService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.cs.demo.constants.WebConstants.DR_NO;

/**
 * @description: 通知服务
 * @author: mingren
 * @data: 2021/4/24 21:57
 **/
@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeEoMapper noticeEoMapper;

    @Override
    public PageResult<NoticeRespDto> page(PageDto reqDto, Long userId) {
        NoticeEoExample eoExample = new NoticeEoExample();
        eoExample.createCriteria().andDrEqualTo(DR_NO).andNoticeUserEqualTo(userId);
        long count = noticeEoMapper.countByExample(eoExample);
        PageResult<NoticeRespDto> pageResult = new PageResult<>();
        pageResult.setTotal(count);
        Integer pageNum = reqDto.getPageNum();
        Integer pageSize = reqDto.getPageSize();
        Integer num = null == pageNum ? WebConstants.DEFAULT_PAGE_NUMBER : pageNum;
        Integer size = null == pageSize ? WebConstants.DEFAULT_PAGE_SIZE : pageSize;
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        List<NoticeRespDto> list = new ArrayList<>();
        if (count > 0) {
            NoticeRespDto dto;
            PageHelper.startPage(num - 1, size);
            List<NoticeEo> eoList = noticeEoMapper.selectByExample(eoExample);
            for (NoticeEo userEo : eoList) {
                dto = new NoticeRespDto();
                BeanUtils.copyProperties(userEo, dto);
                list.add(dto);
            }
        }
        pageResult.setData(list);
        return pageResult;
    }
}
