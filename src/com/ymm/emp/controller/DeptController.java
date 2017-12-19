package com.ymm.emp.controller;

import java.io.IOException;
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

import com.ymm.emp.entity.Dept;
import com.ymm.emp.service.DeptService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/Emp/dept_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( @RequestParam(required=false)String limit,  @RequestParam(required=false)String offset, 
			 @RequestParam(required=false)String address,
		HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Dept> data=deptService.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", data.size());// 总条目数
		map.put("rows", data);// 该页多少行数据
		JSONObject jsonArray = JSONObject.fromObject(map);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}
	
	@RequestMapping(value="del")
	public void del(String ids){
		//获得id列表
		String[] idc = ids.split(",");
		for(int i=0;i<idc.length;i++) {
			deptService.del(idc[i]);
		}
	}
	
	@RequestMapping(value="update")
	public void update(Dept dept,HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		
		if(deptService.update(dept)){
			response.getWriter().write("修改成功!");
		}
	}
	
	@RequestMapping(value="add")
	public void addEmpty(HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		Dept dept=new Dept();
		deptService.save(dept);
	}
	
	@RequestMapping(value = "getAll")
	@ResponseBody
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Dept> data=deptService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(data);
		/*		
		 * for(int i=0;i<data.size();i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("deptno", data.get(i).getDeptno());
			jsonObject.put("dname", data.get(i).getDname());
			jsonArray.add(jsonObject);
		}*/
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}
}
