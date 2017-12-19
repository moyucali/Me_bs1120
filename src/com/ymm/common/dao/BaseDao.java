package com.ymm.common.dao;

import java.util.List;
import java.util.Map;

import com.ymm.common.entity.Page;

public interface BaseDao {
	// 查询全部
	public List<Object> findAll(String str);

	// 查询全部
	public List<Object> findAllByPage(String str,Map<String, Object> map);

	// 根据ID获取对象
	public Object findOneById(String str, String id);

	// 根据对象属性获取
	public List<Object> findOneByProperty(String str, Object Obj);

	// 查询最大ID
	public Object getMaxId(String str);

	// 保存对象
	public Integer insert(String str, Object Obj);

	// 删除对象
	public Integer delById(String str, String id);

	// 更改对象
	public Integer update(String str, Object Obj);

}
