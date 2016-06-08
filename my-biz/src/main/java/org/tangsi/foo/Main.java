package org.tangsi.foo;

public class Main
{

	public static void main(String[] args)
	{
		Foo foo = new Foo();
		foo.run();
		/*ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");

		// 利用aspect 载入时织入,spring ioc容器中的bean以及容器外的bean都能被拦截


		System.out.println("----------------------");
		FooServiceImpl fooServiceImpl = (FooServiceImpl) context.getBean("fooServiceImpl");
		fooServiceImpl.exec();*/

	}

}
