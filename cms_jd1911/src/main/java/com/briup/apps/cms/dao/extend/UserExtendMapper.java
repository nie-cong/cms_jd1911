package com.briup.apps.cms.dao.extend;

import java.util.List;

import com.briup.apps.cms.bean.extend.UserExtend;

/**
*@author:niecong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午4:29:34
*@JDK:JDK1.8
*@说明注解：用户映射接口
*/
public interface UserExtendMapper {
	UserExtend selectById(long id);
	
	
    List<UserExtend> selectAll();
}
