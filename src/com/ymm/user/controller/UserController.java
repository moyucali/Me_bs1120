package com.ymm.user.controller;

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

import com.ymm.user.entity.User;
import com.ymm.user.service.UserService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
		@Autowired
		UserService userServcie;
		@RequestMapping("url")
		public ModelAndView url(){
			return new ModelAndView("Menu/User/user_table");
		}
		@RequestMapping("permiss")
		public ModelAndView permiss(){
			return new ModelAndView("Menu/User/user_permiss_table");
		}
		
		@RequestMapping(value = "queryAll")
		@ResponseBody
		public void findAll( @RequestParam(required=false)String limit,  @RequestParam(required=false)String offset, 
				 @RequestParam(required=false)String address,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
			List<User> data=userServcie.findAll();
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
				userServcie.del(idc[i]);
			}
		}
		
		@RequestMapping(value="update")
		public void update(User user,HttpServletResponse response) throws IOException{
			//System.out.println(order.toString());
			
			if(userServcie.update(user)){
				response.getWriter().write("修改成功!");
			}
		}
		
		@RequestMapping(value="add")
		public void addEmpty(HttpServletResponse response) throws IOException{
			//System.out.println(order.toString());
			User user=new User();
			userServcie.save(user);
		}
}
