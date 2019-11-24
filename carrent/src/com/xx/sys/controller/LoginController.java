package com.xx.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xx.sys.constast.SysConstast;
import com.xx.sys.domain.User;
import com.xx.sys.service.UserService;
import com.xx.sys.utils.WebUtils;
import com.xx.sys.vo.UserVo;

/**
 * 用户登录控制器
 * @author lenovo
 *
 */
@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	/**
	 * 跳转登录页面
	 */
	@RequestMapping("tologin")
	public String toLogin() {
		return "system/main/login";
	}
	
	/**
	 * 登录方法
	 */
	@RequestMapping("login")
	public String login(UserVo userVo ,Model model) {
		User user = userService.login(userVo);
		if(null!=user) {
		  //放入session
			WebUtils.getHttpSession().setAttribute("user", user);
			//记录登录日志 向sys_login_log里面插入数据
			return "system/main/index";
		}else {
			model.addAttribute("error",SysConstast.USER_LOGIN_ERROR_MSG);
			return "system/main/login";
		}
	
	}
	
}
