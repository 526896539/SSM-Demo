package cn.supertimor.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.supertimor.bean.User;
import cn.supertimor.service.UserService;




@Controller
@RequestMapping("/mvc")
public class registerController {
	
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/regist")
	public String regist(){
		return "regist";
	}
	
	
	 	@Resource
	    private UserService userService;
	
		@RequestMapping("/registing")
		public String regist(User user,Model model){
			
			System.out.println("用户注册："+user.getName()+user.getPassword());
			
			userService.regist(user);
			
			model.addAttribute("msg", "注册成功");
			//注册成功后跳转success.jsp页面
			return "success";
		}
		
		@RequestMapping("/logining")
		public String login(String name,String password,Model model){
			
			System.out.println("用户登录："+name+password);
			
			userService.login(name,password);
			
			model.addAttribute("msg", "登录成功");
			
			return "success";
		}
}
