package com.ymm.emp.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ymm.common.dao.BaseDao;
import com.ymm.emp.entity.Dept;
import com.ymm.emp.service.DeptService;

@Service("DeptService")
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl implements DeptService{
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("DeptMapper.findAllDept");
	}

	@Override
	public boolean save(Dept dept) {
		// TODO Auto-generated method stub
		dept.setDeptno(dao.getMaxId("DeptMapper.getMaxIdfromDept").toString());
		int count = dao.insert("DeptMapper.insertDept", dept);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		Dept dept=this.getOne(id);
		dao.update("EmpMapper.emptyDept", dept.getDname());
		int count = dao.delById("DeptMapper.delDeptById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Dept dept) {
		// TODO Auto-generated method stub
		
		int count = dao.update("DeptMapper.updateDept", dept);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Dept getOne(String id) {
		// TODO Auto-generated method stub
		Dept emp=(Dept) dao.findOneById("DeptMapper.getDeptbyId", id);
		return emp;
	}
}
