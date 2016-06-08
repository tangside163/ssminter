/**
 * 
 */
package org.tangsi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangsi.user.vo.UserVo;

/**
 * @author numb
 *
 */
@Controller
@RequestMapping("/aopdemo")
public class AopController
{

	@RequestMapping("/a")
	@ResponseBody
	public UserVo test1(HttpServletRequest request, String name, int age)
	{


		UserVo user = new UserVo();
		user.setName(name);
		user.setAge(age);

		return user;
	}

}
