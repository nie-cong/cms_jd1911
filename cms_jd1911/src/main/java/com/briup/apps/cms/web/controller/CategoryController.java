package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月14日下午3:09:28
*@JDK:JDK1.8
*@说明注解：栏目管理控制器
*/

@RestController
@RequestMapping("/category")
//数据校验可以在下面使用如@NotNull等数据校验
@Validated
@Api("栏目的控制器(文章)")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;
	
	@ApiOperation(value = "查询所有栏目")
	@GetMapping("finaAll")
	public  Message finaAllWithMassage(){
		List<Category> list = categoryService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation(value = "通过id删除栏目")
	@GetMapping("deleteById")
	public  Message deleteByIdWithMassage(long id){
		categoryService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation(value = "通过一组id批量删除栏目")
	@GetMapping("batchDelete")
	public  Message batchDeleteWithMassage(long[] ids){
		categoryService.batchDelete(ids);
		return MessageUtil.success("删除成功");
	}
	
	@ApiOperation(value = "保存或更新文章",notes = "如果参数中有id则为更新操作，若参数中没有id则为保存")
	@PostMapping("saveOrUpdate")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id" ,value = "编号(主键)",paramType = "query",required = false),
		@ApiImplicitParam(name = "name" ,value = "标题名称",paramType = "query",required = true),
		@ApiImplicitParam(name = "description" ,value = "标题描述",paramType = "query",required = true),
		@ApiImplicitParam(name = "no" ,value = "序号",paramType = "query",required = false),
		@ApiImplicitParam(name = "parentId" ,value = "所属父栏目id",paramType = "query",required = false),
	})
	
	//public Message saveOrUpdateWithMessage(Article article) {
	public Message saveOrUpdateWithMessage(
			Long id,
			@NotNull String name,
			@NotNull String description,
			Long no,
			Long parentId) {
		
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setDescription(description);
		category.setNo(no);
		category.setParentId(parentId);		
		categoryService.saveOrUpdate(category);
		return MessageUtil.success("更新成功");
	}
}
