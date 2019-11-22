package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.utils.CustomerException;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午5:15:18
*@JDK:JDK1.8
*@Description：角色业务接口
*/
public interface IRoleService {
	//授权
	void authorization(long roleId,List<Long> privilegeIds);
	
	//查询所有角色
	List<Role> findAll();
	
	//查询角色级联权限
	 List<RoleExtend> cascadePrivilegeFindAll();
	
	//保存或更新信息
	void saveOrUpdate(Role role) throws CustomerException;
	
	//通过id删除角色信息
	void deleteById(long id) throws CustomerException;
	
}
