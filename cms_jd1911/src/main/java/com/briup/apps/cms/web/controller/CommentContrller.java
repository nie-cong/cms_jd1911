package com.briup.apps.cms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.service.ICommentService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午2:47:06
*@JDK:JDK1.8
*@说明注解：评论的控制类
*/
@RestController
@RequestMapping("/comment")
@Api("评论的控制器(文章) ")
public class CommentContrller {
	
	@Autowired
	private ICommentService commentService;
	
	@ApiOperation(value = "查询所有评论")
	@GetMapping("finaAll")
	public  Message finaAllWithMassage(){
	  List<Comment> list = commentService.findAll();
		return MessageUtil.success(list);
	}
	
	@ApiOperation(value = "通过文章id查询文章所有评论")
	@GetMapping("finaByArticleId")
	public  Message finaByArticleId(long article_id){
		List<Comment> list = commentService.selectByArticleId(article_id);
		return MessageUtil.success(list);
	}
	
	
}
