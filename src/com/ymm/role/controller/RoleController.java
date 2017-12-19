package com.ymm.role.controller;

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
import com.ymm.role.entity.Role;
import com.ymm.role.service.RoleService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/Role/role_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( @RequestParam(required=false)String limit,  @RequestParam(required=false)String offset, 
			 @RequestParam(required=false)String address,
		HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Role> data=roleService.findAll();
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
			roleService.del(idc[i]);
		}
	}
	
	@RequestMapping(value="update")
	public void update(Role role,HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		
		if(roleService.update(role)){
			response.getWriter().write("修改成功!");
		}
	}
	
	@RequestMapping(value="add")
	public void addEmpty(HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		Role role=new Role();
		roleService.save(role);
	}
	
	@RequestMapping(value = "getAll")
	@ResponseBody
	public void getAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Role> data=roleService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(data);
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArray.toString());
	}
}
