package com.ymm.emp.service;

import java.util.List;
import com.ymm.emp.entity.Dept;
public interface DeptService {

	public List findAll();
	public boolean save(Dept dept);
	public boolean del(String id);
	public boolean update(Dept dept);
	public Dept getOne(String id);
}
