import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tangsi.address.service.AddressService;
import org.tangsi.address.vo.AddressVo;
import org.tangsi.processor.RegisterProcess;
import org.tangsi.user.service.UserService;
import org.tangsi.user.vo.UserVo;

/**
 * @Project my-biz
 * @Description:
 * @Company youku
 * @Create 2016年3月30日下午2:00:13
 * @author tangsi
 * @version 1.0 Copyright (c) 2016 youku, All Rights Reserved.
 */

public class SpringFrameWorkTest
{

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		UserService userService = (UserService) context.getBean("userServiceImpl");

		/*
		 * UserVo userVo = userService.getUserById(1L);
		 * System.out.println(userVo.getName() + " === " + userVo.getAge());
		 */

		/*
		 * UserVo newVo = new UserVo(); newVo.setAge(29);
		 * newVo.setName("sssss");
		 * 
		 * int num = userService.saveUser(newVo); System.out.println("id =" +
		 * newVo.getId() + ",name=" + newVo.getName() + ", age =" +
		 * newVo.getAge()); System.out.println("num =" + num);
		 */

		AddressService addressService = (AddressService) context.getBean("addressServiceImpl");
		/*
		 * AddressVo addressVo = new AddressVo(); addressVo.setName("湖南湘潭");
		 * addressVo.setUserId(1); addressService.save(addressVo);
		 */

		UserVo userVo = new UserVo();
		userVo.setName("xujiaying");
		userVo.setAge(50);

		AddressVo addressVo = new AddressVo();
		addressVo.setName("深圳");

		RegisterProcess registerProcess = (RegisterProcess) context.getBean("registerProcessImpl");
		registerProcess.handle(userVo, addressVo);
		System.out.println("done...");

	}

}
