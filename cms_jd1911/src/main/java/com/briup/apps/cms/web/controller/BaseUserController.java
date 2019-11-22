package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.UserRoleVM;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午8:19:22
*@JDK:JDK1.8
*@Description：用户基础控制类
*/

@Validated
@RestController
@RequestMapping("/baseUser")
@Api("用户基础信息控制器")
public class BaseUserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询所有要发用户信息")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询所有用户且级联角色",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> list = userService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新用户")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(User baseUser){
        userService.saveOrUpdate(baseUser);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除用户")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        System.out.println(userRoleVM);
        userService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }
}