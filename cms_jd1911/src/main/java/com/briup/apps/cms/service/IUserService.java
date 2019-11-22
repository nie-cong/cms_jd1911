package com.briup.apps.cms.service;

import java.util.List;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月15日下午3:18:16
*@JDK:JDK1.8
*@说明注解：用户业务接口
*/
public interface IUserService {
	//登录
	User login(UserVM userVM) throws CustomerException;
	
	//通过id查询
	UserExtend findById(long id);
	
	//查询所有
	List<User> findAll();
	
	//级联查询
	List<UserExtend> cascadeRoleFindAll();
	
	//保存或更新
	void saveOrUpdate(User user) throws CustomerException;
	
	//更新状态
	void changeStatus(long id,String status) throws CustomerException;
	
	//通过id删除
	void deleteById(long id) throws CustomerException;
	
	//设置角色
	void setRoles(long id, List<Long> roles);
	
}
