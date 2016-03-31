package org.tangsi.user.vo;

import org.apache.ibatis.type.Alias;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月29日下午2:32:40
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

@Alias("user")
public class UserVo
{

	private Long id;

	private String name;

	private Integer age;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

}
