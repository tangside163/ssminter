package org.tangsi.dubbo.service;

import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年6月15日下午5:21:04
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public interface DemoService
{
	public UserVo getUser(String id);
}
