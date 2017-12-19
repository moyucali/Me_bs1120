package com.ymm.product.service;

import java.util.List;

import com.ymm.product.entity.Product;

public interface ProductService {
	public List findAll();
	public boolean save(Product product);
	public boolean del(String id);
	public boolean update(Product product);
	public Product getOne(String id);
}
