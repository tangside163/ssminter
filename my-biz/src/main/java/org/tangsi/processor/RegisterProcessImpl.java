package org.tangsi.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tangsi.address.service.AddressService;
import org.tangsi.address.vo.AddressVo;
import org.tangsi.user.service.UserService;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月31日下午1:44:16
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

@Service("registerProcessImpl")
public class RegisterProcessImpl implements RegisterProcess
{

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void handle(UserVo userVo, AddressVo addressVo)
	{

		this.userService.saveUser(userVo);
		addressVo.setUserId(userVo.getId());
		this.addressService.save(addressVo);

		// throw new RuntimeException();
	}

}
