package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

public interface IArticleService {
	List<Article> findAll();
	
	List<ArticleExtend> cascadeFindAll();
	
	ArticleExtend findById(long id);
	
	void deleteById(long id)throws CustomerException;
	
	//批量删除
	void batchDelete(long[] ids)throws CustomerException;
		
	//抛出自定义的异常
	void saveOrUpdate(Article article) throws CustomerException;
}
