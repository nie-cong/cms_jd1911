package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.PrivilegeTree;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午8:02:55
*@JDK:JDK1.8
*@Description：
*/
public interface IPrivilegeService {
	//查询所有权限 
	List<Privilege> findAll();
	
	// 通过parentId查询权限
	 List<Privilege> findByParentId(Long parentId);
	 
	 //保存或更新权限 
	 void saveOrUpdate(Privilege privilege) throws CustomerException;

	 //查询权限树
	List<PrivilegeTree> findPrivilegeTree();
	
	//查询所有用户权限
	List<Privilege> findByUserId(long id);
	
	//通过id删除
	void deleteById(long id);
}
