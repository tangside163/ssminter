package org.tangsi.advice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.tangsi.util.HttpRequestUtil;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception e, HttpServletRequest request) {
		if (!HttpRequestUtil.isAjaxRequest(request)) {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("exception", e.getStackTrace().toString());
			modelAndView.setViewName("error.jsp");
			return modelAndView;
		} else {
			// ajax 请求返回ajax错误视图
			Map<String, Object> map = new HashMap<>();
			map.put("errorMsg", e.getMessage());
			return new ModelAndView(new FastJsonJsonView(), map);
		}
	}

}
