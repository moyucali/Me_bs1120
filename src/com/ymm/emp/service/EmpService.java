package com.ymm.emp.service;

import java.util.List;

import com.ymm.emp.entity.Emp;


public interface EmpService {

	public List findAll();
	public boolean save(Emp emp);
	public boolean del(String id);
	public boolean update(Emp emp);
	public Emp getOne(String id);
}
