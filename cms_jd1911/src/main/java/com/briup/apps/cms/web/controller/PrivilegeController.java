package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.service.IPrivilegeService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import com.briup.apps.cms.vm.PrivilegeTree;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午8:25:10
*@JDK:JDK1.8
*@Description：权限控制器
*/
@Validated
@RestController
@RequestMapping("/privilege")
@Api("权限的控制器(角色)")
public class PrivilegeController {

    @Autowired
    private IPrivilegeService privilegeService;

    @ApiOperation(value = "查询所有权限")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<Privilege> list = privilegeService.findAll();
        return MessageUtil.success(list);
    }



    @ApiOperation(value = "通过parentId查询权限")
    @GetMapping(value = "findByParentId")
    public Message findByParentId(Long id){
        List<Privilege> list = privilegeService.findByParentId(id);
        return MessageUtil.success(list);
    }

    @ApiOperation(value ="保存或更新权限")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege){
        privilegeService.saveOrUpdate(privilege);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "查询权限树")
    @GetMapping(value = "findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> list = privilegeService.findPrivilegeTree();
        return MessageUtil.success(list);
    }
    
    @ApiOperation(value = "通过id删除角色")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        privilegeService.deleteById(id);
        return MessageUtil.success("删除成功");
    }



}
