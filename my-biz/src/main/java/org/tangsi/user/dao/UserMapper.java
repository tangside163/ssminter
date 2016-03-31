package org.tangsi.user.dao;

import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月29日下午2:39:12
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public interface UserMapper
{

	UserVo findUserById(Long id);

	int save(UserVo userVo);

}
