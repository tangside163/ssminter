package org.tangsi.user.service;

import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月29日下午2:32:16
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public interface UserService
{

	UserVo getUserById(Long id);
	
	int saveUser(UserVo userVo);

}
