package com.ymm.log.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ymm.common.dao.BaseDao;
import com.ymm.log.entity.LogBean;

@Service("LogUtil")
@Transactional(rollbackFor = Exception.class)
public class LogUtil {
	@Resource(name="baseDao")
	BaseDao dao;
	public void in(String uname,String method) {
		LogBean log=new LogBean();
		if(dao.getMaxId("LogMapper.getMaxIdbyLog")==null) {
			log.setId("1");
		}else {
			log.setId(dao.getMaxId("LogMapper.getMaxIdbyLog").toString());
		}
		log.setUname(uname);
		
		if(method.equals("register")) {method="�û�ע��";}
		if(method.equals("login")) {method="�û���¼";}
		if(method.equals("getUserInfo")) {method="������ҳ";}
		if(method.equals("findAll")) {method="��ѯ����";}
		if(method.equals("save")) {method="��Ӳ���";}
		if(method.equals("update")) {method="�޸Ĳ���";}
		if(method.equals("del")) {method="ɾ������";}
		log.setMethod(method);
		Date date = new Date(); 
		SimpleDateFormat from = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		String times = from.format(date); 
		log.setTime(times);
		dao.insert("LogMapper.insertLog", log);
	}
	
	public List out() {
		return dao.findAll("LogMapper.findAllLog");
	}
	
	public void clear() {
		dao.delById("LogMapper.clear",null);
	}
}
