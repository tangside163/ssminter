package org.tangsi.address.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tangsi.address.dao.AddressMapper;
import org.tangsi.address.service.AddressService;
import org.tangsi.address.vo.AddressVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月31日上午11:19:31
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

@Service("addressServiceImpl")
public class AddressServiceImpl implements AddressService
{

	@Autowired
	private AddressMapper addressMapper;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int save(AddressVo addressVo)
	{
		return this.addressMapper.save(addressVo);
	}

}
