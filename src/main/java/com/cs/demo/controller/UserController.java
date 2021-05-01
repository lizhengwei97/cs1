package com.cs.demo.controller;

import com.cs.demo.dto.BaseResponse;
import com.cs.demo.dto.PageResult;
import com.cs.demo.dto.request.UserReqDto;
import com.cs.demo.dto.response.UserRespDto;
import com.cs.demo.eo.UserEo;
import com.cs.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 登录接口
 **/
@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "登录接口")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @GetMapping("/getInfo")
    public BaseResponse<UserRespDto> getInfo() {
        UserRespDto respDto = new UserRespDto();
        UserEo userEo = getUserInfo();
        BeanUtils.copyProperties(userEo, respDto);
        return new BaseResponse(respDto);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> add(@RequestBody UserReqDto reqDto) {
        userService.addUser(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> update(@RequestBody UserReqDto reqDto) {
        userService.updateUser(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/upPwd")
    public BaseResponse<Boolean> updatePwd(@RequestBody UserReqDto reqDto) {
        userService.updateUserPwd(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/restPwd")
    public BaseResponse<Boolean> restPwd(@RequestBody UserReqDto reqDto) {
        userService.restPwd(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/del")
    public BaseResponse<Boolean> del(@RequestBody UserReqDto reqDto) {
        userService.delUser(reqDto, getUserInfo());
        return new BaseResponse(Boolean.TRUE);
    }

    @PostMapping("/page")
    public BaseResponse<PageResult<UserRespDto>> page(@RequestBody UserReqDto reqDto) {
        return new BaseResponse(userService.page(reqDto, getUserInfo()));
    }

    @GetMapping("/getRoleList")
    public BaseResponse<Map<String, String>> getRoleList() {
        return new BaseResponse(userService.getRoleList(getUserInfo()));
    }

    @GetMapping("/getRelUser")
    public BaseResponse<UserReqDto> getRelUser() {
        return new BaseResponse(userService.getRelUserByRole(getUserId()));
    }
}
