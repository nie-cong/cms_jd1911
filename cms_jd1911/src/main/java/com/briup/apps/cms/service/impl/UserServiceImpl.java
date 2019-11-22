package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.bean.User_Role;
import com.briup.apps.cms.bean.User_RoleExample;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.dao.UserMapper;
import com.briup.apps.cms.dao.User_RoleMapper;
import com.briup.apps.cms.dao.extend.UserExtendMapper;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.CustomerException;
import com.briup.apps.cms.vm.UserVM;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月15日下午3:18:57
*@JDK:JDK1.8
*@说明注解：用户业务实现类
*/
@Service
public class UserServiceImpl implements IUserService{
	@Resource
	private UserExtendMapper userExtendMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private User_RoleMapper userRoleMapper;
	
	
	@Override
	public UserExtend findById(long id) {
		return userExtendMapper.selectById(id);
	}

	@Override
	public List<User> findAll() {	
		return userMapper.selectByExample(new UserExample());
	}

	@Override
	public List<UserExtend> cascadeRoleFindAll() {
		return userExtendMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(User user) throws CustomerException {
		if(user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        } else {
            // 判断用户名是否被占用
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(user.getUsername());
            List<User> list =userMapper.selectByExample(example);
            if(list.size()>0){
                throw new CustomerException("该用户已经被占用");
            }
            // 初始化用户的一些值
            user.setRegisterTime(new Date().getTime());
            user.setStatus(UserExtend.STATUS_NORMAL);
            userMapper.insert(user);
        }
		
	}
	
	
	@Override
	public void changeStatus(long id, String status) throws CustomerException {
		 	User user = userMapper.selectByPrimaryKey(id);
	        if(user==null){
	            throw new CustomerException("该用户不存在");
	        }
	        user.setStatus(status);
	        userMapper.updateByPrimaryKey(user);
		
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		User user = userMapper.selectByPrimaryKey(id);
        if(user==null){
            throw new CustomerException("该用户不存在");
        }      
		userMapper.deleteByPrimaryKey(id);
	}
	
	
	//设置角色
	@Override
	public void setRoles(long id, List<Long> roles) {
		// 根据userid查询自己的角色
        User_RoleExample example = new User_RoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        // 用户角色关系,获取所有老的角色
        List<User_Role> list = userRoleMapper.selectByExample(example);
        List<Long> oldRoles = new ArrayList<>();
        Iterator<User_Role> iterator = list.iterator();
        while(iterator.hasNext()){
            oldRoles.add(iterator.next().getRoleId());
        }
        // [1,2,3] -> [3,4] 添加1,2 => [1,2,3,4]
        // 依次判断新角色是否存在于list中，如果不存在则添加
        for(Long roleId : roles){
            if(!oldRoles.contains(roleId)){
                User_Role userRole = new User_Role();
                userRole.setRoleId(roleId);
                userRole.setUserId(id);
                userRoleMapper.insert(userRole);
            }
        }
        // [1,2,3] -> [1,2,3,4]   删除 3,4  => [1,2]
        // 依次判断老的角色是否存在于roles中，如果不存在则删除
        for(User_Role userRole : list){
            if(!roles.contains(userRole.getRoleId())){
             User_RoleExample example1 = new User_RoleExample();
             userRoleMapper.deleteByPrimaryKey(userRole.getId());
            }
        }
		
	}
	
	//登录
	@Override
	public User login(UserVM userVM) throws CustomerException {
		UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(userVM.getUsername());
        List<User> list = userMapper.selectByExample(example);
        if(list.size()<=0){
            throw new CustomerException("该用户不存在");
        }
        User user = list.get(0);
        if(!user.getPassword().equals(userVM.getPassword())){
            throw new CustomerException("密码不匹配");
        }
        return user;
	}

}
