package com.briup.apps.cms.bean.extend;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午5:12:11
*@JDK:JDK1.8
*@Description：角色扩展类
*/
public class RoleExtend extends Role{
	//角色对应的权限，多个权限
	private List<Privilege> privileges;

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
