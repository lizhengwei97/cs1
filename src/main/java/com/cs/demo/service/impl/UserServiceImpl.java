package com.cs.demo.service.impl;

import com.cs.demo.constants.WebConstants;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.UserReqDto;
import com.cs.demo.dto.response.UserRespDto;
import com.cs.demo.eo.*;
import com.cs.demo.mapper.RoleEoMapper;
import com.cs.demo.mapper.UserEoMapper;
import com.cs.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static com.cs.demo.constants.WebConstants.*;

/**
 * @Author:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserEoMapper userEoMapper;
    @Autowired
    private RoleEoMapper roleEoMapper;

    @Override
    public void addUser(UserReqDto reqDto, UserEo currUser) {
        if (StringUtils.isBlank(reqDto.getUserCode())) {
            throw new RuntimeException("缺少参数");
        }
        UserEoExample userEoExample = new UserEoExample();
        userEoExample.createCriteria().andUserCodeEqualTo(reqDto.getUserCode());
        long count = userEoMapper.countByExample(userEoExample);
        if (count > 0) {
            throw new RuntimeException("用户名已存在");
        }
        RoleEoKey roleEo = new RoleEoKey();
        roleEo.setId(Long.valueOf(currUser.getRoleId()));
        RoleEo roleEoList = roleEoMapper.selectByPrimaryKey(roleEo);
  //      if (null != roleEoList) {
    //        throw new RuntimeException("当前用户不能添加用户");
    //    }
        UserEo userEo = new UserEo();
        BeanUtils.copyProperties(reqDto, userEo);
        userEo.setPwd("123456");
        userEo.setRelUser(currUser.getId());
        userEo.setRoleId(roleEoList.getId());
        userEo.setRoleName(roleEoList.getRoleName());
        userEo.setCreateTime(new Date());
        userEo.setUpdateTime(new Date());
        userEo.setDr(DR_NO);
        userEo.setCreatePerson(currUser.getId().toString());
        userEo.setUpdatePerson(currUser.getId().toString());
        userEoMapper.insert(userEo);
    }

    @Override
    public void updateUser(UserReqDto reqDto, UserEo currUser) {
        UserEo userEo = new UserEo();
        BeanUtils.copyProperties(reqDto, userEo);
        userEo.setUpdateTime(new Date());
        userEo.setUpdatePerson(currUser.getId().toString());
        userEoMapper.updateByPrimaryKeySelective(userEo);
    }

    @Override
    public void updateUserPwd(UserReqDto reqDto, UserEo currUser) {
        if (!currUser.getPwd().equals(reqDto.getOldPwd())) {
            throw new RuntimeException("旧密码不正确");
        }
        UserEo userEo = new UserEo();
        userEo.setId(currUser.getId());
        userEo.setPwd(reqDto.getNewPwd());
        userEo.setUpdateTime(new Date());
        userEoMapper.updateByPrimaryKeySelective(userEo);
    }

    @Override
    public void restPwd(UserReqDto reqDto, UserEo currUser) {
        if (!currUser.getRoleId().equals(ADMIN_ROLE_ID)) {
            throw new RuntimeException("当前用户不能操作");
        }
        UserEo userEo = new UserEo();
        userEo.setId(reqDto.getId());
        userEo.setPwd("123456");
        userEo.setUpdateTime(new Date());
        userEo.setUpdatePerson(currUser.getId().toString());
        userEoMapper.updateByPrimaryKeySelective(userEo);
    }

    @Override
    public void delUser(UserReqDto reqDto, UserEo currUser) {
        if (!currUser.getRoleId().equals(ADMIN_ROLE_ID)) {
            throw new RuntimeException("当前用户不能操作");
        }
        UserEoKey key = new UserEoKey();
        key.setId(reqDto.getId());
        userEoMapper.deleteByPrimaryKey(key);
    }

    @Override
    public PageResult<UserRespDto> page(UserReqDto reqDto, UserEo currUser) {
        UserEoExample eoExample = new UserEoExample();
        UserEoExample.Criteria cri = eoExample.createCriteria();
        if (!currUser.getRoleId().equals(ADMIN_ROLE_ID)) {
            cri.andRelUserEqualTo(currUser.getId());
        }
        if (StringUtils.isNotBlank(reqDto.getUserName())) {
            cri.andUserNameLike("%" + reqDto.getUserName() + "%");
        }
        cri.andDrEqualTo(DR_NO);
        // eoExample.createCriteria().andEmailLike(reqDto.getUserEmail());
        long count = userEoMapper.countByExample(eoExample);
        PageResult<UserRespDto> pageResult = new PageResult<>();
        pageResult.setTotal(count);
        Integer pageNum = reqDto.getPageNum();
        Integer pageSize = reqDto.getPageSize();
        Integer num = null == pageNum ? WebConstants.DEFAULT_PAGE_NUMBER : pageNum;
        Integer size = null == pageSize ? WebConstants.DEFAULT_PAGE_SIZE : pageSize;
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        List<UserRespDto> list = new ArrayList<>();
        if (count > 0) {
            UserRespDto dto;
            PageHelper.startPage(num - 1, size);
            List<UserEo> userEoList = userEoMapper.selectByExample(eoExample);
            for (UserEo userEo : userEoList) {
                dto = new UserRespDto();
                BeanUtils.copyProperties(userEo, dto);
                list.add(dto);
            }
        }
        pageResult.setData(list);
        return pageResult;
    }

    @Override
    public Map<String, String> getRoleList(UserEo currUser) {
        Map<String, String> map = new HashMap<>(0);
        RoleEoExample roleEoExample = new RoleEoExample();
        roleEoExample.createCriteria().andParIdEqualTo(currUser.getRoleId());
        List<RoleEo> roleEoList = roleEoMapper.selectByExample(roleEoExample);
        if (!CollectionUtils.isEmpty(roleEoList)) {
            for (RoleEo eo : roleEoList) {
                map.put(eo.getId().toString(), eo.getRoleName());
            }
        }
        return map;
    }

    @Override
    public List<UserRespDto> getRelUserByRole(Long userId) {
        List<UserRespDto> list = new ArrayList<>();
        UserRespDto dto;
        UserEoExample eoExample = new UserEoExample();
        UserEoExample.Criteria cri = eoExample.createCriteria();
        cri.andRelUserEqualTo(userId).andRoleIdEqualTo(TEACHER_ROLE_ID);
        List<UserEo> userEoList = userEoMapper.selectByExample(eoExample);
        for (UserEo userEo : userEoList) {
            dto = new UserRespDto();
            BeanUtils.copyProperties(userEo, dto);
            list.add(dto);
        }
        return list;
    }

}
