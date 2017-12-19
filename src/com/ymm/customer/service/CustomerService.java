package com.ymm.customer.service;
import java.util.List;
import com.ymm.customer.entity.Customer;
public interface CustomerService {

	/**
	 * ��ȡ�����û�
	 * 
	 * @return
	 */
	public List findAll();
	/**
	 * ��ȡ�����û�
	 * 
	 * @return
	 */
	public List findAll(String search);
	/**
	 * �������û�
	 * @param user
	 * @return
	 */
	public boolean save(Customer customer);
	/**
	 * ����IDɾ��
	 * 
	 * @param id
	 */
	public boolean del(String id);
	/**
	 * ���²���
	 * 
	 * @param user
	 */
	public boolean update(Customer customer);

	public Customer getOne(String id);
}
