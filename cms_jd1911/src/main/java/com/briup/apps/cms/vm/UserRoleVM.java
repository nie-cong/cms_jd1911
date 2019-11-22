package com.briup.apps.cms.vm;

import java.util.List;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午8:15:52
*@JDK:JDK1.8
*@Description：用户角色
*/
public class UserRoleVM {
	private Long id;
	private List<Long> roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Long> getRoles() {
		return roles;
	}
	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}
	
	
}
