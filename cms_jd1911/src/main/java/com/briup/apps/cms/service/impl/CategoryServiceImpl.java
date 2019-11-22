package com.briup.apps.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.CategoryExample;
import com.briup.apps.cms.dao.CategoryMapper;
import com.briup.apps.cms.service.ICategoryService;
import com.briup.apps.cms.utils.CustomerException;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月14日下午3:06:21
*@JDK:JDK1.8
*@说明注解：栏目的业务实现类
*/

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAll() {
		return categoryMapper.selectByExample(new CategoryExample());
	}

	
	@Override
	public void saveOrUpdate(Category category) throws CustomerException {
		//判断是保存还是更新，通过判断是否存在id
		if(category.getId()!=null) {
			//更新操作
			categoryMapper.updateByPrimaryKey(category);
		}else {
			
			CategoryExample example =new CategoryExample();
			//判断标题是否重名
			example.createCriteria().andNameEqualTo(category.getName());
			List<Category> list=categoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("该栏目已经存在");
			}else {
				//插入操作
				categoryMapper.insert(category);
			}
		
		}
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Category category = categoryMapper.selectByPrimaryKey(id);
		if(category==null) {
			throw new CustomerException("要删除的栏目不存在，请刷新后重试");
		}else {
			categoryMapper.deleteByPrimaryKey(id);
		}
		
	}

	//批量删除
	@Override
	public void batchDelete(long[] ids) throws CustomerException {
		//循环遍历ids数组，调用上面通过id删除栏目的方式
		for(long id:ids) {
			this.deleteById(id);
		}
		
	}

}
