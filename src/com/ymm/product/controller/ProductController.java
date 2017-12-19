package com.ymm.product.controller;

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
import com.ymm.product.entity.Product;
import com.ymm.product.service.ProductService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/Product/product_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Product> data=productService.findAll();
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
			productService.del(idc[i]);
		}
	}
	
	@RequestMapping(value="update")
	public void update(Product product,HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		
		if(productService.update(product)){
			response.getWriter().write("修改成功!");
		}
	}
	
	@RequestMapping(value="add")
	public void addEmpty(HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		Product product=new Product();
		productService.save(product);
	}
	
	@RequestMapping(value="get")
	public ModelAndView getMap(@RequestParam(required=false)String id,HttpServletResponse response) throws IOException{
		System.out.println("get:"+id);
		Product product=productService.getOne(id);
		return new ModelAndView("Menu/Product/product_info","product",product);
	}
}
