package com.briup.apps.cms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RoleExample;
import com.briup.apps.cms.bean.Role_Privilege;
import com.briup.apps.cms.bean.Role_PrivilegeExample;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.Role_PrivilegeMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.CustomerException;

/**
*@author:nie-cong
*@author_CSDN:人间四月天的水中月
*@version：1.0
*@Date：2019年11月18日下午8:07:00
*@JDK:JDK1.8
*@Description：角色业务实现类
*/
@Service
public class RoleServiceImpl  implements IRoleService{
	 	@Resource
	    private RoleMapper roleMapper;
	    @Resource
	    private RoleExtendMapper roleExtendMapper;
	    @Resource
	    private Role_PrivilegeMapper rolePrivilegeMapper;
	    
	    //授权
	    @Override
	    public void authorization(long roleId, List<Long> privilegeIds) {
	        // 根据roleid查询出所有的权限
	        Role_PrivilegeExample example = new Role_PrivilegeExample();
	        example.createCriteria().andRoleIdEqualTo(roleId);
	        List<Role_Privilege> list = rolePrivilegeMapper.selectByExample(example);
	        // 将list转换为privilegeIDs的集合
	        List<Long> old_privilegeIds = new ArrayList<>();
	        for(Role_Privilege rp : list){
	            old_privilegeIds.add(rp.getPrivilegeId());
	        }
	        // 依次判断privilegeIds 是否存在old_privilegeIds，如果不在则插入
	        for(long privilegeId : privilegeIds){
	            if (!old_privilegeIds.contains(privilegeId)) {
	                Role_Privilege rp = new Role_Privilege();
	                rp.setRoleId(roleId);
	                rp.setPrivilegeId(privilegeId);
	                rolePrivilegeMapper.insert(rp);
	            }
	        }
	        // 依次判断 是否存在old_privilegeIds 是否存在privilegeIds，如果不存在删除
	        for(long privilegeId: old_privilegeIds){
	            if(!privilegeIds.contains(privilegeId)){
	                // 根据privilegeId 从桥表中删除
	                example.clear();
	                example.createCriteria()
	                        .andRoleIdEqualTo(roleId)
	                        .andPrivilegeIdEqualTo(privilegeId);
	                rolePrivilegeMapper.deleteByExample(example);
	            }
	        }

	    }

	    @Override
	    public List<Role> findAll() {

	        return roleMapper.selectByExample(new RoleExample());
	    }

	    @Override
	    public List<RoleExtend> cascadePrivilegeFindAll() {
	        return roleExtendMapper.selectAllWithPrivilege();
	    }

	    @Override
	    public void saveOrUpdate(Role baseRole) throws CustomerException {
	        if(baseRole.getId()!=null){
	            roleMapper.updateByPrimaryKey(baseRole);
	        } else {
	            roleMapper.insert(baseRole);
	        }
	    }

	    @Override
	    public void deleteById(long id) throws CustomerException {
	        Role role = roleMapper.selectByPrimaryKey(id);
	        if(role == null){
	            throw new CustomerException("要删除的角色不存在");
	        }
	        roleMapper.deleteByPrimaryKey(id);
	    }

}
