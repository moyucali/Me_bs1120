package com.ymm.login.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ymm.user.entity.User;
import com.ymm.login.service.LoginService;

/**
 * @author Arica
 *
 */
@Controller
public class LoginController {
	/**
	 * 查询数据库后将结果返回页面
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public void login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("访问：ModelAndView Login");
		System.out.println("username："+user.getUsername()+" password："+user.getPassword());
		HttpSession session = request.getSession();
		if (loginService.login(user)) {
			user=loginService.getUserInfo(user);
			session.setAttribute("user", user);
			session.setAttribute("uname", user.getUsername());
			response.getWriter().print("success");
		}

	}
	
	/**
	 * 切换用户
	 * @return
	 */
	@RequestMapping(value = "loginout")
	public ModelAndView swUser(HttpServletRequest request) {
		// return "redirect:index.jsp";
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("index");
	}
	
	/**
	 * 主页跳转
	 * @param checkCode
	 * @return
	 */
	@RequestMapping(value = "index")
	public ModelAndView index(String checkCode) {
		// return "redirect:index.jsp";
		return new ModelAndView("index");
	}

	/**
	 * ajax登录后处理
	 * 
	 * @param checkCode
	 * @return
	 */
	@RequestMapping(value = "after")
	public ModelAndView login2( HttpServletRequest request) {
		// return "redirect:index.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			return new ModelAndView("404");
		}
		return new ModelAndView("Menu/menu");
	}

	/**
	 * 注册
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "register")
	@ResponseBody
	public void register(User user, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("访问：ModelAndView Register");
		// System.out.println("registerContoler： username："+username+"
		// password："+password);
		response.setCharacterEncoding("utf-8");
		if (loginService.register(user)) {
			response.getWriter().print("注册成功!");
		} else {
			response.getWriter().print("发生未知的错误,注册失败!");
		}

	}

	/**
	 * 注入loginService
	 * 
	 * @param loginService
	 */
	@Autowired
	LoginService loginService;
}
