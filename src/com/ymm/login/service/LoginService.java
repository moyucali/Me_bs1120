package com.ymm.login.service;

import java.util.List;

import com.ymm.user.entity.User;

/**
 * @author Arica
 *
 */
public interface LoginService {

	/**
	 * µÇÂ¼
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean login(User user);

	/**
	 * ×¢²á
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public Boolean register(User user);
	
	public User getUserInfo(User user);
}
