package com.ymm.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymm.common.entity.Page;

@Repository("baseDao")
public class BaseDaoSupport implements BaseDao {

	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Object> findAll(String str) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(str);
	}
	
	@Override
	public List<Object> findAllByPage(String str,Map<String, Object> map){
		// TODO Auto-generated method stub
		return sqlSession.selectList(str, map);
	}

	@Override
	public Object findOneById(String str, String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(str, id);
	}

	@Override
	public List<Object> findOneByProperty(String str, Object Obj) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(str, Obj);
	}

	@Override
	public Object getMaxId(String str) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(str);
	}

	@Override
	public Integer insert(String str, Object Obj) {
		// TODO Auto-generated method stub
		return sqlSession.insert(str, Obj);
	}

	@Override
	public Integer delById(String str, String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete(str, id);
	}

	@Override
	public Integer update(String str, Object Obj) {
		// TODO Auto-generated method stub
		return sqlSession.update(str, Obj);
	}

}
