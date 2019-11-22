package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.utils.CustomerException;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月14日下午2:58:40
*@JDK:JDK1.8
*@说明注解：栏目sercive层接口，定义一些方法
*/
public interface ICategoryService {
	List<Category> findAll();
	
	void saveOrUpdate(Category category) throws CustomerException;
	
	void deleteById(long id)throws CustomerException;
	
	//批量删除
	void batchDelete(long[] ids)throws CustomerException;
	
	
}
