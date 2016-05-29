/**
 * 
 */
package org.tangsi.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author numb
 *
 */
public class HttpRequestUtil {

	/**
	 * 判断是否是ajax请求
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("x-requested-with");
		if ("XMLHttpRequest".equals(header))
			return true;
		return false;
	}

}
