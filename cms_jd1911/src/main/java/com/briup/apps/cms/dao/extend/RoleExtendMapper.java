package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RoleExtend;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午5:10:13
*@JDK:JDK1.8
*@Description：角色的扩展映射接口
*/
public  interface RoleExtendMapper {
	 List<Role> selectByUserId(long id);

	 List<RoleExtend> selectAllWithPrivilege();
}
