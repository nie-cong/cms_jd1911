package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.User;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午4:27:16
*@JDK:JDK1.8
*@说明注解：用户的扩展类
*/
public class UserExtend extends User {
	public static final String STATUS_NORMAL="正常";
    public static final String STATUS_FORBIDDEN="禁用";

    private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
    
}
