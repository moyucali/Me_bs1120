package com.ymm.customer.service;
import java.util.List;
import com.ymm.customer.entity.Customer;
public interface CustomerService {

	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public List findAll();
	/**
	 * 获取所有用户
	 * 
	 * @return
	 */
	public List findAll(String search);
	/**
	 * 保存新用户
	 * @param user
	 * @return
	 */
	public boolean save(Customer customer);
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
	public boolean update(Customer customer);

	public Customer getOne(String id);
}
