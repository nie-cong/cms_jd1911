package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.extend.ArticleExtend;
/** 
 * 
 * @author nc
 *这是对Article文章类进行了扩展，加入了Category栏目和User后的映射接口
 * ArticleExtendMapper.xml文件是通过级联查询，通过Article文章类的category_id,查到对象Category栏目，
 * 通过author_id，查找对象User用户
 *  */
public interface ArticleExtendMapper {
	List<ArticleExtend> selectAll();
	
	ArticleExtend selectById(long id);
}
