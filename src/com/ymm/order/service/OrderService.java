package com.ymm.order.service;

import java.util.List;

import com.ymm.order.entity.Order;

public interface OrderService {
		public List findAll();
		public Order findOneById(String id);
		public boolean save(Order order);
		public boolean del(String id);
		public boolean update(Order order);
}
