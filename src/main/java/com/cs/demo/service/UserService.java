package com.cs.demo.service;

import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.UserReqDto;
import com.cs.demo.dto.response.UserRespDto;
import com.cs.demo.eo.UserEo;

import java.util.List;
import java.util.Map;

/**
 * @Author:
 */
public interface UserService {
    void addUser(UserReqDto reqDto, UserEo userEo);

    void updateUser(UserReqDto reqDto, UserEo currUser);

    void updateUserPwd(UserReqDto reqDto, UserEo userEo);

    void restPwd(UserReqDto reqDto, UserEo userEo);

    void delUser(UserReqDto reqDto, UserEo currUser);

    PageResult<UserRespDto> page(UserReqDto reqDto, UserEo currUser);

    Map<String, String> getRoleList(UserEo currUser);

    List<UserRespDto> getRelUserByRole(Long userId);
}
