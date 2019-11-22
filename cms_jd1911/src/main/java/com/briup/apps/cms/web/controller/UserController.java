package com.briup.apps.cms.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.JwtTokenUtil;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午6:41:19
*@JDK:JDK1.8
*@Description：用户登陆的控制器类
*/


@Validated
@RestController
@RequestMapping("/user")
@Api("用户登陆的控制器")
public class UserController {

    @Autowired
    private IUserService userService;
    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public Message login(@RequestBody UserVM userVM){
    	// 1. 认证用户的用户名和密码
        User user = userService.login(userVM);
        // 2. 如果登录成功产生token,将token缓存起来，返回
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUsername());
        
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtil.success(map);
        
        // 3. 如果登录失败
        //UserServiceImpl处理了，用户名密码不正确
    	
//    	//暂时写死
//        Map<String,String> map = new HashMap<>();
//        map.put("token","admin-token");
//        return MessageUtil.success(map);
    }

    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
    	long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        UserExtend baseUserExtend = userService.findById(id);
        return MessageUtil.success(baseUserExtend);
        
//    	//暂时写死
//        UserExtend userExtend = userService.findById(1l);
//        return MessageUtil.success(userExtend);
    }
    
    @ApiOperation(value = "用户登出")
    @PostMapping("logout")
    public Message logout(){
        // 1. 登录， token从缓存中移除掉
        return MessageUtil.success("退出成功");
    }


}
