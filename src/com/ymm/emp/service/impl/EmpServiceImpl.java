package com.ymm.emp.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ymm.common.dao.BaseDao;
import com.ymm.emp.entity.Emp;
import com.ymm.emp.service.EmpService;
@Service("EmpService")
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService{
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("EmpMapper.findAllEmp");
	}

	@Override
	public boolean save(Emp emp) {
		// TODO Auto-generated method stub
		emp.setEmpno(dao.getMaxId("EmpMapper.getMaxIdfromEmp").toString());
		int count = dao.insert("EmpMapper.insertEmp", emp);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("EmpMapper.delEmpById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Emp emp) {
		// TODO Auto-generated method stub
		
		int count = dao.update("EmpMapper.updateEmp", emp);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Emp getOne(String id) {
		// TODO Auto-generated method stub
		Emp emp=(Emp) dao.findOneById("EmpMapper.getEmpbyId", id);
		return emp;
	}

}
