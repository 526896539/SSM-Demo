package cn.supertimor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.supertimor.bean.User;
import cn.supertimor.service.UserService;

@Controller
@RequestMapping("/mvc")
public class UserController {

	@Autowired
	private UserService userService;
	
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
	
	@RequestMapping("/regist.action")
	public String regist(User user,Model model){
		System.out.println("用户注册："+user.getUser_name()+user.getPassword()+user.getAge());
		user.setId(2);
		user.setAge(20);
		userService.regist(user);
		 model.addAttribute("msg", "注册成功");  
	        //注册成功后跳转success.jsp页面  
	        return "success";  
		
	}
	
	@RequestMapping("/login.action")  
    public String login(String user_name,String password,Model model){  
          
       System.out.println("用户登录："+user_name+password);  
        userService.login(user_name,password);   
        model.addAttribute("msg", "登录成功");     
        return "success";  
	}
	
}
