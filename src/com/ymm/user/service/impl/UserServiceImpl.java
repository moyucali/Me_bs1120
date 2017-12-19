package com.ymm.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymm.common.dao.BaseDao;
import com.ymm.user.entity.User;
import com.ymm.user.service.UserService;

@Service("UserService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
	@Resource(name="baseDao")
	BaseDao dao;

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("UserMapper.findAllUser");
	}

	@Override
	public User findOnebyId(String id) {
		// TODO Auto-generated method stub
		return (User) dao.findOneById("UserMapper.findUserById", id);
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		user.setId(dao.getMaxId("UserMapper.getMaxIdFromUser").toString());
		user.setUsername("");user.setPassword("");
		int count = dao.insert("UserMapper.insertUser", user);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("UserMapper.delUserById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		int count = dao.update("UserMapper.updateUser", user);
		if (count >= 0) {
			return true;
		}
		return false;
	}


}
