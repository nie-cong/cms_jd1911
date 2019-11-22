package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.dao.extend.CommentExtendMapper;
import com.briup.apps.cms.service.ICommentService;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午2:40:13
*@JDK:JDK1.8
*@说明注解：
*/
@Service
public class CommentServiceImpl implements ICommentService{

	@Resource
	private CommentExtendMapper  commentExtendMapper;
	@Override
	public List<Comment> findAll() {
		return commentExtendMapper.selectAll();
	}
	@Override
	public List<Comment> selectByArticleId(long article_id) {
		return commentExtendMapper.selectByArticleId(article_id);
	}

}
