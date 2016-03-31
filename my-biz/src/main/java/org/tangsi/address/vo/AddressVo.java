package org.tangsi.address.vo;

import org.apache.ibatis.type.Alias;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月31日上午11:13:47
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

@Alias("address")
public class AddressVo
{

	private long id;

	private long userId;

	private String name;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public long getUserId()
	{
		return userId;
	}

	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
