/**
 * 
 */
package org.tangsi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tangsi.foo.Foo;

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
	public String test1(HttpServletRequest request, String name, int age)
	{

		Foo foo = new Foo();
		foo.run();
		return "success";

	}

}
