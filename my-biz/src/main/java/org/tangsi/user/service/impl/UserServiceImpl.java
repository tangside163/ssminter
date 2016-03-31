package org.tangsi.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tangsi.user.dao.UserMapper;
import org.tangsi.user.service.UserService;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月29日下午2:37:02
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService
{

	@Autowired
	private UserMapper userMapper;

	@Transactional(readOnly = true)
	@Override
	public UserVo getUserById(Long id)
	{
		return this.userMapper.findUserById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int saveUser(UserVo userVo)
	{
		return this.userMapper.save(userVo);
	}

}
