/**
 * 
 */
package org.tangsi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tangsi.vo.User;

import com.alibaba.fastjson.JSON;

/**
 * @author numb
 *
 */
@Controller
@RequestMapping("/aopdemo")
public class AopController {

	@RequestMapping("/a")
	public String test1(HttpServletRequest request, String name, int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		return JSON.toJSONString(user);

	}

}
