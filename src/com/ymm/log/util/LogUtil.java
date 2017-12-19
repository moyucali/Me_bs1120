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
		
		if(method.equals("register")) {method="用户注册";}
		if(method.equals("login")) {method="用户登录";}
		if(method.equals("getUserInfo")) {method="访问主页";}
		if(method.equals("findAll")) {method="查询操作";}
		if(method.equals("save")) {method="添加操作";}
		if(method.equals("update")) {method="修改操作";}
		if(method.equals("del")) {method="删除操作";}
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
