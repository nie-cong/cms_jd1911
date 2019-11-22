package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.vm.PrivilegeTree;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午5:31:15
*@JDK:JDK1.8
*@Description：权限的映射接口
*/
public interface PrivilegeExtendMapper {
	List<PrivilegeTree> selectAll();

    List<Privilege> selectByParentId(long id);

    List<Privilege> selectByRoleId(long id);
    
    List<Privilege> selectByUserId(long id);
}
