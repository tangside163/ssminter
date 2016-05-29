/**
 * 
 */
package org.tangsi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.tangsi.vo.Group;
import org.tangsi.vo.Hunter;
import org.tangsi.vo.User;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author numb
 *
 */
public class JsonTest {

	@Test
	public void test1() {
		Group group = new Group();
		group.setId(3);
		group.setName("xiangtan");

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setAge(20 + i);
			user.setName("ts" + i);

			users.add(user);
		}
		
		group.setUsers(users);
		
		System.out.println(JSON.toJSONString(group, true));
		
		System.out.println(JSON.toJSON(group));
	}
	
	@Test
	public void test2()
	{
		String json = "{\"id\":3,\"users\":[{\"name\":\"ts0\",\"age\":20},{\"name\":\"ts1\",\"age\":21},{\"name\":\"ts2\",\"age\":22}],\"name\":\"xiangtan\"}";
		
		Group group = JSON.parseObject(json, Group.class);
		
		System.out.println(group.getName());
		
		for(User user : group.getUsers())
		{
			System.out.println(user.getName());
		}
	}
	
	@Test
	public void test3()
	{
		Hunter<Group> hunter = new Hunter<>();
		
		Group group = new Group();
		group.setId(3);
		group.setName("xiangtan");

		List<User> users = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setAge(20 + i);
			user.setName("ts" + i);

			users.add(user);
		}
		
		group.setUsers(users);
		
		hunter.setTag("猎人");
		
		hunter.setData(group);
		
		System.out.println(JSON.toJSON(hunter));
		
	}
	
	@Test
	public void test4()
	{
		String json = "{\"tag\":\"猎人\",\"data\":{\"id\":3,\"users\":[{\"name\":\"ts0\",\"age\":20},{\"name\":\"ts1\",\"age\":21},{\"name\":\"ts2\",\"age\":22}],\"name\":\"xiangtan\"}}";
		
		Hunter<Group> hunter = JSON.parseObject(json, new TypeReference<Hunter<Group>>(){});
		
		System.out.println("tag = " + hunter.getTag());
		
		Group group = hunter.getData();
		
		System.out.println(group.getName());
		
		for(User user : group.getUsers())
		{
			System.out.println(user.getAge() + "---" + user.getName());
		}
	}
	
	@Test
	public void test5()
	{
		String str = "在";
		System.out.println(JSON.toJSONString(str/*, SerializerFeature.BrowserCompatible*/));
	}
	
	/**
	 * 生成json是否用单引号，默认双引号
	 */
	@Test
	public void test6()
	{
		User user = new User();
		user.setAge(22);
		user.setName("ts");
		System.out.println(JSON.toJSONString(user/*, SerializerFeature.UseSingleQuotes*/));
	}
	
	@Test
	public void test7()
	{
		Group group = new Group();
		group.setName("xt");
		
		System.out.println(JSON.toJSONString(group/*, SerializerFeature.WriteNullListAsEmpty*/));
	}

}
