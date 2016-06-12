/**
 * 
 */
package org.tangsi.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private Logger logger = LogManager.getLogger(AopController.class);
	
	private Logger fileLogger = LogManager.getLogger("org.apache.log4j.biz");
	
	@RequestMapping("/a")
	@ResponseBody
	public UserVo test1(HttpServletRequest request, String name, int age)
	{

		logger.info("进入aopController");
		fileLogger.info("aopcontroller写文件");
		
		UserVo user = new UserVo();
		user.setName(name);
		user.setAge(age);

		return user;
	}

}
