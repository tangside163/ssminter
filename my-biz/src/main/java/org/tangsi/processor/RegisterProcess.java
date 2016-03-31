package org.tangsi.processor;

import org.tangsi.address.vo.AddressVo;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description: 
 * @Company youku
 * @Create 2016年3月31日上午11:55:17
 * @author tangsi
 * @version 1.0
 * Copyright (c) 2016 youku, All Rights Reserved.
 */

public interface RegisterProcess
{
	public void handle(UserVo userVo, AddressVo addressVo);
}
