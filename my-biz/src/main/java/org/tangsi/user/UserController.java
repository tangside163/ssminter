package org.tangsi.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tangsi.user.service.UserService;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月29日下午2:27:53
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

@Controller
@RequestMapping("/user")
public class UserController
{

	@Autowired
	private UserService userService;

	public String showUser(String id, HttpServletRequest request)
	{
		UserVo user = this.userService.getUserById(Long.parseLong(id));
		request.setAttribute("user", user);
		return "user/user.jsp";
	}

}
