package com.ymm.user.service;
import java.util.List;
import com.ymm.user.entity.User;
/**
 * @author Arica
 *
 */
public interface UserService {

	/**
	 * ��ȡ�����û�
	 * 
	 * @return
	 */
	public List findAll();
	/**
	 * ����ID��ȡ
	 * 
	 * @return
	 */
	public User findOnebyId(String id);
	/**
	 * �������û�
	 * @param user
	 * @return
	 */
	public boolean save(User user);
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
	public boolean update(User user);
}
