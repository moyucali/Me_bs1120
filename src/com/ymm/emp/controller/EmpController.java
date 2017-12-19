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

import com.ymm.emp.entity.Emp;
import com.ymm.emp.service.EmpService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	EmpService empService;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/Emp/emp_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( @RequestParam(required=false)String limit,  @RequestParam(required=false)String offset, 
			 @RequestParam(required=false)String address,
		HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Emp> data=empService.findAll();
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
			empService.del(idc[i]);
		}
	}
	
	@RequestMapping(value="update")
	public void update(Emp emp,HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		
		if(empService.update(emp)){
			response.getWriter().write("修改成功!");
		}
	}
	
	@RequestMapping(value="add")
	public void addEmpty(HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		Emp emp=new Emp();
		empService.save(emp);
	}
	
	@RequestMapping(value="get")
	public ModelAndView getMap(@RequestParam(required=false)String empno,HttpServletResponse response) throws IOException{
		System.out.println("get:"+empno);
		Emp emp=empService.getOne(empno);
		return new ModelAndView("Menu/Emp/emp_info","emp",emp);
	}
}
