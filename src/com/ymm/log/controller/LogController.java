package com.ymm.log.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ymm.log.entity.LogBean;
import com.ymm.log.util.LogUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	LogUtil log;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/System/log_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( @RequestParam(required=false)Integer limit,  @RequestParam(required=false)Integer offset, 
			 @RequestParam(required=false)String search,
		HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<LogBean> data=log.out();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", data.size());// 总条目数
		map.put("rows", data);// 该页多少行数据
		JSONObject jsonArray = JSONObject.fromObject(map);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}
	
	@RequestMapping(value = "clear")
	@ResponseBody
	public void clean(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.clear();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("clear");
	}
}
