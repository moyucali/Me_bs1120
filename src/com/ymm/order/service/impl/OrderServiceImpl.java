package com.ymm.order.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymm.common.dao.BaseDao;
import com.ymm.common.entity.Page;
import com.ymm.order.entity.Order;
import com.ymm.order.service.OrderService;

@Service("OrderService")
@Transactional(rollbackFor = Exception.class)
public class OrderServiceImpl implements OrderService{
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("OrderMapper.findAllOrder");
	}

	@Override
	public Order findOneById(String id) {
		// TODO Auto-generated method stub
		return (Order) dao.findOneById("OrderMapper.findOrderById", id);
	}

	@Override
	public boolean save(Order order) {
		// TODO Auto-generated method stub
		order.setOrderid(dao.getMaxId("OrderMapper.getMaxId").toString());
		order.setStatus("Î´·¢»õ");
		int count = dao.insert("OrderMapper.insertOrder", order);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("OrderMapper.delOrderById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Order order) {
		// TODO Auto-generated method stub
		
		int count = dao.update("OrderMapper.updateOrder", order);
		if (count >= 0) {
			return true;
		}
		return false;
	}

}
