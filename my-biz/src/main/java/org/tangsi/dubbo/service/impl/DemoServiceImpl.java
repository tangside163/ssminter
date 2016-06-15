package org.tangsi.dubbo.service.impl;

import org.tangsi.dubbo.service.DemoService;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年6月15日下午5:21:55
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public class DemoServiceImpl implements DemoService
{

	@Override
	public UserVo getUser(String id)
	{
		UserVo user = new UserVo();
		user.setId(Long.valueOf(id));
		user.setAge(20 + Integer.valueOf(id));
		user.setName("name" + id);
		return user;
	}

}
