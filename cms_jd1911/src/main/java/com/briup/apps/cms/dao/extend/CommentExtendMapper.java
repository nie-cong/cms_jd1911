package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Comment;

/**
 * 
 * @author nc
 *Comment评论扩展映射接口
 */
public interface CommentExtendMapper {
	List<Comment> selectByArticleId(long article_id);
	
	List<Comment> selectAll();
}
