package com.ymm.login.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ymm.login.service.LoginService;
import com.ymm.common.dao.BaseDao;
import com.ymm.user.entity.User;

/**
 * @author Arica
 *
 */
@Service("loginService")
@Transactional(rollbackFor = Exception.class)
public class LoginServiceImpl implements LoginService {
	@Resource(name="baseDao")
	BaseDao dao;

	/**
	 * 登錄方法
	 * 
	 * @return
	 */
	@Override
	public Boolean login(User user) {
		int count = dao.findOneByProperty("UserMapper.findUserByProperty", user).size();
		if (count >= 1) {
			return true;
		}
		return false;
	}
	/**
	 * 注册方法
	 */
	@Override
	public Boolean register(User user) {
		// TODO Auto-generated method stub
		user.setId(dao.getMaxId("UserMapper.getMaxIdFromUser").toString());
		user.setManager("普通管理员");
		int count = dao.insert("UserMapper.insertUser", user);
		if (count >= 0) {
			return true;
		}
		return false;
	}
	@Override
	public User getUserInfo(User user) {
		// TODO Auto-generated method stub
		user = (User) dao.findOneByProperty("UserMapper.findUserByProperty", user).get(0);
		return user;
	}

}
