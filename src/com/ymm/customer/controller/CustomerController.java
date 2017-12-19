package com.ymm.customer.controller;
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
import com.ymm.customer.entity.Customer;
import com.ymm.customer.service.CustomerService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "url")
	@ResponseBody
	public ModelAndView url(){
		return new ModelAndView("Menu/Customer/customer_table");
	}
	
	@RequestMapping(value = "queryAll")
	@ResponseBody
	public void findAll( @RequestParam(required=false)Integer limit,  @RequestParam(required=false)Integer offset, 
			 @RequestParam(required=false)String search,
		HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("limit="+limit+" "+"offset="+offset);
		System.out.println("search="+search);
		List<Customer> data=customerService.findAll(search);
		int dSize=data.size();
		List<Customer> nData=new ArrayList<Customer>();
		for(int i=offset;i<limit+offset ;i++) {
			if(i==data.size()) {break;}
			nData.add(data.get(i));
			if(data.size()==1) {break;}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", dSize);// 总条目数
		map.put("rows", nData);// 该页多少行数据
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
			customerService.del(idc[i]);
		}
	}
	
	@RequestMapping(value="update")
	public void update(Customer customer,HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		
		if(customerService.update(customer)){
			response.getWriter().write("修改成功!");
		}
	}
	
	@RequestMapping(value="add")
	public void addEmpty(HttpServletResponse response) throws IOException{
		//System.out.println(order.toString());
		Customer customer=new Customer();
		customerService.save(customer);
	}
	
	@RequestMapping(value="get")
	public ModelAndView getMap(@RequestParam(required=false)String id,HttpServletResponse response) throws IOException{
		System.out.println("get:"+id);
		Customer customer=customerService.getOne(id);
		return new ModelAndView("Menu/Customer/customer_info","customer",customer);
	}
}
