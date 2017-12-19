package com.ymm.role.service;
import java.util.List;
import com.ymm.role.entity.Role;

public interface RoleService {
	public List findAll();
	public boolean save(Role role);
	public boolean del(String id);
	public boolean update(Role role);
}
