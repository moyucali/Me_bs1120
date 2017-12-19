package com.ymm.order.controller;

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
import com.ymm.order.entity.Order;
import com.ymm.order.service.OrderService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderController {
		@Autowired
		OrderService orderService;
		
		@RequestMapping("url")
		public ModelAndView url(){
			return new ModelAndView("Menu/Order/order_table");
		}
		
		@RequestMapping(value = "queryAll")
		@ResponseBody
		public void findAll( @RequestParam(required=false)String limit,  @RequestParam(required=false)String offset, 
				 @RequestParam(required=false)String address,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			List<Order> data=orderService.findAll();
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
			System.out.println("OrderController：获得的id列表："+ids);
			String[] idc = ids.split(",");
			for(int i=0;i<idc.length;i++) {
				orderService.del(idc[i]);
			}
		}
		
		@RequestMapping(value="update")
		public void update(Order order,HttpServletResponse response) throws IOException{
			//System.out.println(order.toString());
			
			if(orderService.update(order)){
				response.getWriter().write("修改成功!");
			}
		}
		
		@RequestMapping(value="add")
		public void addEmpty(HttpServletResponse response) throws IOException{
			//System.out.println(order.toString());
			Order order=new Order();
			orderService.save(order);
		}
		
		@RequestMapping(value="send")
		public void sendOrder(HttpServletResponse response,String orderid) throws IOException{
			Order order=orderService.findOneById(orderid);
			order.setStatus("已发货");
			orderService.update(order);
		}
		
		@RequestMapping(value="cancel")
		public void cencelOrder(HttpServletResponse response,String orderid) throws IOException{
			Order order=orderService.findOneById(orderid);
			order.setStatus("待发货");
			orderService.update(order);
		}
		
		@RequestMapping(value="complite")
		public void comliteOrder(HttpServletResponse response,String orderid) throws IOException{
			Order order=orderService.findOneById(orderid);
			order.setStatus("已完成");
			orderService.update(order);
		}
}
