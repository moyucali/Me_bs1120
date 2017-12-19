package com.ymm.common.dao;

import java.util.List;
import java.util.Map;

import com.ymm.common.entity.Page;

public interface BaseDao {
	// ��ѯȫ��
	public List<Object> findAll(String str);

	// ��ѯȫ��
	public List<Object> findAllByPage(String str,Map<String, Object> map);

	// ����ID��ȡ����
	public Object findOneById(String str, String id);

	// ���ݶ������Ի�ȡ
	public List<Object> findOneByProperty(String str, Object Obj);

	// ��ѯ���ID
	public Object getMaxId(String str);

	// �������
	public Integer insert(String str, Object Obj);

	// ɾ������
	public Integer delById(String str, String id);

	// ���Ķ���
	public Integer update(String str, Object Obj);

}
