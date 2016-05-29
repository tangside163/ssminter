package org.tangsi.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;
import org.tangsi.function.MyExcelView;
import org.tangsi.function.MyPdfView;
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
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/detail")
	public String showUser(String id, HttpServletRequest request) {
		UserVo user = this.userService.getUserById(Long.parseLong(id));
		request.setAttribute("user", user);
		return "user/user.jsp";
	}

	@RequestMapping("/detail/{id}")
	public String showUser2(@PathVariable("id") String userId, HttpServletRequest request) {
		UserVo user = this.userService.getUserById(Long.parseLong(userId));
		request.setAttribute("user", user);
		// return "user/user.jsp";
		return "user/user.ftl";
	}

	@RequestMapping("/genexcel")
	public ModelAndView generateExcel() {
		AbstractView excelView = new MyExcelView();
		return new ModelAndView(excelView, new HashMap<String, String>());
	}

	@RequestMapping("/genpdf")
	public ModelAndView generatePdf() {
		AbstractView pdfView = new MyPdfView();
		return new ModelAndView(pdfView, new HashMap<String, String>());
	}

	@RequestMapping("/addJob")
	public void addJob(String jobName, @RequestParam("groupName") String jobGroupName, String cron) {

	}

	/**
	 * 返回json数据
	 * 
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public Map<String, Object> getUser() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "ts");
		map.put("age", 24);
		map.put("country", "中国");
		return map;
	}

}
