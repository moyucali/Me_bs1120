package com.ymm.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymm.common.dao.BaseDao;
import com.ymm.customer.entity.Customer;
import com.ymm.customer.service.CustomerService;

@Service("CustomerService")
@Transactional(rollbackFor = Exception.class)
public class CustomerServiceImpl implements CustomerService {
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("CustomerMapper.findAllCustomer");
	}

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		customer.setCid(dao.getMaxId("CustomerMapper.getMaxIdfromCustomer").toString());
		int count = dao.insert("CustomerMapper.insertCustomer", customer);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("CustomerMapper.delCustomerById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		
		int count = dao.update("CustomerMapper.updateCustomer", customer);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Customer getOne(String id) {
		// TODO Auto-generated method stub
		Customer cust=(Customer) dao.findOneById("CustomerMapper.getCustomerbyId", id);
		return cust;
	}

	@Override
	public List findAll(String search) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("search", search);
		return dao.findAllByPage("CustomerMapper.findCustomerLike",map);
	}



}
