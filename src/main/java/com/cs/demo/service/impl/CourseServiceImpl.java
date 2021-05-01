package com.cs.demo.service.impl;

import com.cs.demo.constants.WebConstants;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.CourseReqDto;
import com.cs.demo.dto.response.CourseRespDto;
import com.cs.demo.eo.CourseEo;
import com.cs.demo.eo.CourseEoExample;
import com.cs.demo.eo.NoticeEo;
import com.cs.demo.eo.UserEo;
import com.cs.demo.mapper.CourseEoMapper;
import com.cs.demo.mapper.NoticeEoMapper;
import com.cs.demo.service.CourseService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.cs.demo.constants.WebConstants.DR_NO;
import static com.cs.demo.constants.WebConstants.MAX_COURSE_TIME;

/**
 * @Author:
 */
@Service
@Slf4j
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseEoMapper courseEoMapper;
    @Autowired
    private NoticeEoMapper noticeEoMapper;

    @Override
    public void add(CourseReqDto reqDto, UserEo currUser) {
        CourseEo eo = new CourseEo();
        BeanUtils.copyProperties(reqDto, eo);
        eo.setRelUser(currUser.getId());
        eo.setCreateTime(new Date());
        eo.setUpdateTime(new Date());
        eo.setDr(DR_NO);
        eo.setCreatePerson(currUser.getId().toString());
        eo.setUpdatePerson(currUser.getId().toString());
        courseEoMapper.insertSelective(eo);
        if (courseOverTime(reqDto.getUserId(), reqDto.getSemester())) {
            saveNotice(reqDto.getUserId(), reqDto.getCourseName(), currUser.getUserName(), currUser.getId());
        }
    }

    @Override
    public void update(CourseReqDto reqDto, UserEo currUser) {
        if (null == reqDto.getId()) {
            return;
        }
        CourseEo eo = new CourseEo();
        BeanUtils.copyProperties(reqDto, eo);
        eo.setId(reqDto.getId());
        eo.setUpdateTime(new Date());
        eo.setUpdatePerson(currUser.getId().toString());
        courseEoMapper.updateByPrimaryKeySelective(eo);
        if (courseOverTime(reqDto.getUserId(), reqDto.getSemester())) {
            saveNotice(reqDto.getUserId(), reqDto.getCourseName(), currUser.getUserName(), currUser.getId());
        }
    }

    @Override
    public PageResult<CourseRespDto> page(CourseReqDto reqDto, UserEo currUser) {
        PageResult<CourseRespDto> pageResult = new PageResult<>();
        CourseEoExample eoExample = new CourseEoExample();
        eoExample.createCriteria().andRelUserEqualTo(currUser.getId());
        long count = courseEoMapper.countByExample(eoExample);
        pageResult.setTotal(count);
        Integer pageNum = reqDto.getPageNum();
        Integer pageSize = reqDto.getPageSize();
        Integer num = null == pageNum ? WebConstants.DEFAULT_PAGE_NUMBER : pageNum;
        Integer size = null == pageSize ? WebConstants.DEFAULT_PAGE_SIZE : pageSize;
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        List<CourseRespDto> list = new ArrayList<>();
        if (count > 0) {
            CourseRespDto dto;
            PageHelper.startPage(num - 1, size);
            List<CourseEo> userEoList = courseEoMapper.selectByExample(eoExample);
            for (CourseEo userEo : userEoList) {
                dto = new CourseRespDto();
                BeanUtils.copyProperties(userEo, dto);
                list.add(dto);
            }
        }
        pageResult.setData(list);
        return pageResult;
    }

    /**
     * 判断是否超时
     *
     * @param userId
     * @return
     */
    private boolean courseOverTime(Long userId, String semester) {
        boolean isOver = false;
        CourseEoExample eoExample = new CourseEoExample();
        eoExample.createCriteria().andUserIdEqualTo(userId).andSemesterEqualTo(semester);
        List<CourseEo> eoList = courseEoMapper.selectByExample(eoExample);
        if (!CollectionUtils.isEmpty(eoList)) {
            int count = 0;
            for (CourseEo c : eoList) {
                if (null != c.getCourseTimes()) {
                    count += c.getCourseTimes();
                }
            }
            isOver = count > MAX_COURSE_TIME;
        }
        return isOver;
    }

    private void saveNotice(Long userId, String courseName, String useName, Long currId) {
        NoticeEo eo = new NoticeEo();
        eo.setTitle(courseName + "超时预警");
        eo.setNoticeUser(userId);
        eo.setContent(courseName + "超时预警!!!\n" + useName + "在" + new Date() + "操作您的课时");
        eo.setCreateTime(new Date());
        eo.setUpdateTime(new Date());
        eo.setDr(DR_NO);
        eo.setCreatePerson(currId.toString());
        eo.setUpdatePerson(currId.toString());
        noticeEoMapper.insertSelective(eo);
    }

}
