package com.ymm.user.service;
import java.util.List;
import com.ymm.user.entity.User;
/**
 * @author Arica
 *
 */
public interface UserService {

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public List findAll();
	/**
	 * 根据ID获取
	 * 
	 * @return
	 */
	public User findOnebyId(String id);
	/**
	 * 保存新用户
	 * @param user
	 * @return
	 */
	public boolean save(User user);
	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	public boolean del(String id);
	/**
	 * 更新操作
	 * 
	 * @param user
	 */
	public boolean update(User user);
}
