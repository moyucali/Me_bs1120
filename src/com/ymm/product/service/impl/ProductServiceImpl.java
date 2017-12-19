package com.ymm.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ymm.common.dao.BaseDao;
import com.ymm.order.entity.Order;
import com.ymm.product.entity.Product;
import com.ymm.product.service.ProductService;

@Service("ProductService")
@Transactional(rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {
	@Resource(name="baseDao")
	BaseDao dao;
	
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return dao.findAll("ProductMapper.findAllProduct");
	}

	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		product.setPid(dao.getMaxId("ProductMapper.getMaxIdfromProduct").toString());
		int count = dao.insert("ProductMapper.insertProduct", product);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean del(String id) {
		// TODO Auto-generated method stub
		int count = dao.delById("ProductMapper.delProductById", id);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		
		int count = dao.update("ProductMapper.updateProduct", product);
		if (count >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Product getOne(String id) {
		// TODO Auto-generated method stub
		return (Product)dao.findOneById("ProductMapper.findProductById", id);
	}



}
