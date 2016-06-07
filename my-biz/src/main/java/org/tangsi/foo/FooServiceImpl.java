package org.tangsi.foo;

import org.springframework.stereotype.Component;

@Component
public class FooServiceImpl
{

	public void exec()
	{
		System.out.println("FooServiceImpl.exec()");
	}
}
