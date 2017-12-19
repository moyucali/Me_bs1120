package com.ymm.role.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ymm.common.dao.BaseDao;
import com.ymm.role.entity.Role;
import com.ymm.role.service.RoleService;
@Service("RoleService")
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService{
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("RoleMapper.findAllRole");
	}

	@Override
	public boolean save(Role role) {
		// TODO Auto-generated method stub
		role.setRid(dao.getMaxId("RoleMapper.getMaxIdfromRole").toString());
		int count = dao.insert("RoleMapper.insertRole", role);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("RoleMapper.delRoleById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Role role) {
		// TODO Auto-generated method stub
		
		int count = dao.update("RoleMapper.updateRole", role);
		if (count >= 0) {
			return true;
		}
		return false;
	}

}
