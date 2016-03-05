package com.crossengage.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.crossengage.model.User;
import com.crossengage.service.UserService;

public class UnitTest {

	UserService userService;

	@Before
	public void onceExecutedBeforeAll() {
		if (userService == null)
			userService = new UserService();
		System.out.println("executed before all");
	}

	@Test
	public void saveUser1test() {
		User user = new User("Onur", "Karaduman", "onrkrdmn@gmail.com");
		Boolean save = userService.save(user);
		Assert.assertTrue("Success", save == true);
	}

	@Test
	public void saveUser2test() {
		User user = new User("Recep", "May", "recepmay@gmail.com");
		Boolean save = userService.save(user);
		Assert.assertTrue("Success", save == true);
	}

	@Test
	public void saveUser3test() {
		User user = new User("Serden", "Bulut", "serdenbulut@gmail.com");
		Boolean save = userService.save(user);
		Assert.assertTrue("Success", save == true);
	}

	@Test
	public void findAllUses() {
		List<User> findAllUser = userService.findAllUser();
		Assert.assertTrue("Success", !findAllUser.isEmpty());
	}

	@Test
	public void findAllActiveUsers() {
		List<User> findActiveUser = userService.findActiveUser();
		Assert.assertTrue("Success", !findActiveUser.isEmpty());
	}

	@Test
	public void sendMailToActiveUsers() {
		List<User> findActiveUser = userService.findActiveUser();
		Boolean sendMail = userService.sendMail("Test email from Onur", findActiveUser);
		Assert.assertTrue("Success", sendMail == true);
	}
}
