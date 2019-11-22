package com.briup.apps.cms.vm;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午6:37:44
*@JDK:JDK1.8
*@Description：权限树
*/
public class PrivilegeTree extends Privilege{
	private List<Privilege> children;

	public List<Privilege> getChildren() {
		return children;
	}

	public void setChildren(List<Privilege> children) {
		this.children = children;
	}
	
}
