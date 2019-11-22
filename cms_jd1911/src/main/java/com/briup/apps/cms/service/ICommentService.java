package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午2:40:13
*@JDK:JDK1.8
*@说明注解：评论业务接口
*/
public interface ICommentService {
	List<Comment> findAll();
	
	List<Comment> selectByArticleId(long article_id);
}
