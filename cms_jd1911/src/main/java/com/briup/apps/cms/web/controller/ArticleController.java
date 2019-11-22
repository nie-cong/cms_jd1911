package com.briup.apps.cms.web.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 文章控制器类
 **/
@RestController
@RequestMapping("/article")
//数据校验可以在下面使用如@NotNull等数据校验
@Validated
@Api(value = "文章的控制器")
public class ArticleController {
	@Autowired
	private IArticleService articleService;
	
//	/** 普通查询 */
//	@GetMapping("finaAll")
//	public List<Article> finaAll(){
//		return articleService.findAll();
//	}
//
//	/**
//	 * 级联查询，查询Article文章，同时通过栏目category_id查到Category相关信息 
//	 **/
//	@GetMapping("cascadeFindAll")
//	public List<ArticleExtend> cascadeFindAll(){
//		return articleService.cascadeFindAll();
//	}
//	
//	/**
//	 * 通过id查询单篇文章
//	 **/
//	@GetMapping("findById")
//	public ArticleExtend findById(long id) {
//		return articleService.findById(id);
//	}

 // @ApiOperation对类进行作用注解到swagger页面

	
	/** 普通查询 ，
	 * 带有查询信息message等，统一了查询结果格式
	 * 
	 * */
	
	@ApiOperation(value = "查询所有文章")
	@GetMapping("finaAll")
	public  Message finaAllWithMassage(){
		List<Article> list=articleService.findAll();
		return MessageUtil.success(list);
	}
	
	/**
	 * 级联查询，查询Article文章，同时通过栏目category_id查到Category相关信息 
	 * 带有Message信息，统一了查询结果格式
	 * 
	 **/
	@ApiOperation(value = "级联查询所有文章",notes = "级联了Category栏目和User作者表")
	@GetMapping("cascadeFindAll")
	public Message cascadeFindAllWithMessage(){
		List<ArticleExtend> list=articleService.cascadeFindAll();
		return MessageUtil.success(list);
	}
	
	
	/**
	 * 通过id查询单篇文章
	 * 带有Message信息，统一了查询结果格式
	 **/
	
	//@ApiImplicitParam对参数进行注解，默认jesn格式，要设置成paramType = "query"，否则后台拿到
	@ApiOperation(value = "通过id查询某篇文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id" ,value = "编号(主键)",paramType = "query")
	})
	@GetMapping("findById")
	public Message findByIdWithMessage(long id) {
		ArticleExtend articleExtend=articleService.findById(id);
		return MessageUtil.success(articleExtend);
	}
	
	/**
	 * 通过id删除单篇文章
	 * 带有Message信息，统一了查询结果格式
	 **/
	
	//@ApiImplicitParam对参数进行注解，默认jesn格式，要设置成paramType = "query"，否则后台拿到
	@ApiOperation(value = "通过id删除某篇文章")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id" ,value = "编号(主键)",paramType = "query")
	})
	@GetMapping("deleteById")
	public Message deleteByIdWithMessage(long id) {
		articleService.deleteById(id);
		return MessageUtil.success("删除成功");
	}
	@ApiOperation(value = "通过id数组ids删除多篇篇文章")
	@GetMapping("batchDelete")
	public Message batchDeleteWithMessage(long[] ids) {
		articleService.batchDelete(ids);
		return MessageUtil.success("删除成功");
	}
	
	
	/**
	 * 更新或保存文章
	 * 带有Message信息，统一了查询结果格式
	 **/
	/*
	 * @ApiImplicitParams：用在请求的方法上，表示一组参数说明
	 * 
	 * @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面 name：参数名
	 * value：参数的汉字说明、解释 
	 * required：参数是否必须传 
	 * paramType：参数放在哪个地方 
	 */
	@ApiOperation(value = "保存或更新文章信息",notes = "如果参数中包含id后端认为是更新操作，如果参数中不包含id认为是插入操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
            @ApiImplicitParam(name = "title", value = "标题",paramType = "form",required = true),
            @ApiImplicitParam(name = "content", value = "内容",paramType = "form",required = true),
            @ApiImplicitParam(name = "source", value = "源内容",paramType = "form",required = false),
            @ApiImplicitParam(name = "categoryId", value = "所属栏目id",paramType = "form",required = true),
            @ApiImplicitParam(name = "authorId", value = "所属作者id",paramType = "form",required = false)
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull long categoryId,
            Long authorId){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }
}
