package com.briup.apps.cms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;
/**
 * 文章业务实现类 
 **/
@Service
public class ArticleServiceImpl implements IArticleService{
	@Resource
	private ArticleMapper  articleMapper;
	@Resource
	private ArticleExtendMapper  articleExtendMapper;
	
	
	/**
	 * 普通单表查询Article文章
	 */
	@Override
	public List<Article> findAll() {
		
		return articleMapper.selectByExample(new ArticleExample());
	}

	/**
	 * 级联查询，
	 *在ArticleExtendMapper.xml文件中 ：
	 * 查询Article文章和通过category_id找到对应的栏目
	 * 通过author_id，查找对象User用户
	 */
	@Override
	public List<ArticleExtend> cascadeFindAll() {
		return articleExtendMapper.selectAll();
	}
     
	/**
	 * 通过id查询Article文章
	 * 
	 */
	@Override
	public ArticleExtend findById(long id) {
		return articleExtendMapper.selectById(id); 
	}
	
	/**
	 * 保存或更新Article文章
	 */
	@Override
	public void saveOrUpdate(Article article) throws CustomerException{
		if(article.getId()!=null) {
			//表示Article文章id不为空，则是更新操作
			article.setPublishTime(new Date().getTime());
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			articleMapper.updateByPrimaryKey(article);
		}else {
			//表示Article文章为空，则为保存操作，第一次发布文章需要设置下列值
			
			//标题不能重名
			ArticleExample example=new ArticleExample();
			//通过Title查找example对象获取
			example.createCriteria().andTitleEqualTo(article.getTitle());
			//同过example对象查找Article对象
			List<Article> articles=articleMapper.selectByExample(example);
			if(articles.size()>0){
				//Article文章数据库中有了此title文章
				throw new CustomerException("标题不能重复");
			}
			//初始化
			//设置时间
			article.setPublishTime(new Date().getTime());
			//设置文章状态为未审核
			article.setStatus(ArticleExtend.STATUS_UNCHECK);
			//设置点赞数为0
			article.setThumbUp(0l);
			//设置不喜欢数为0
			article.setThumbDown(0l);
			//更新或保存文章
			articleMapper.insert(article);
			
			
		}
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		 Article article = articleMapper.selectByPrimaryKey(id);
		if(article==null) {
			throw new CustomerException("要删除的文章不存在，请刷新后重试");
		}else {
			articleMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public void batchDelete(long[] ids) throws CustomerException {
		//遍历id数组，调用通过id删除的方法批量删除
		for(long id:ids) {
			deleteById(id);
		}
		
	}
  
  
}
