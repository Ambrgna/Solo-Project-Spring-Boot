package com.example.demo;

import com.genspark.SpringBootdemoApplication.Entity.User;
import com.genspark.SpringBootdemoApplication.Service.UserService;
import com.genspark.SpringBootdemoApplication.SpringBootdemoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = SpringBootdemoApplication.class)
class UserServiceTests {
	private List<String> list;
	private User u;
	private int userid;
	private String username;
	@Autowired
	private UserService userService;

	public UserServiceTests() {
	}

	@BeforeEach
	void init() {
		System.out.println("startup");
		u = new User("testing", "1234", "ROLE_LEAD");
		u = userService.addUser(u);
		userid = u.getUserId();
		username = u.getUsername();
	}
	@AfterEach
	void teardown() {
		System.out.println("teardown");
		userService.deleteUserById(userid);
	}
	@Test
	void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		boolean returnStatment= false;
		for (User user:users) {
			if (u.toString().equals(user.toString())){
				returnStatment=true;
			}
		}
		assertTrue(returnStatment);
	}
	@Test
	void testGetUserByUsername() {
		User user = userService.getUserByUsername(username);
		assertTrue(u.toString().equals(user.toString()));
	}
	@Test
	void testGetUserById() {
		User testUser = userService.getUserById(userid);
		boolean returnStatment= false;

		if (u.toString().equals(testUser.toString())){
			returnStatment=true;
		}

		assertTrue(returnStatment);
	}
	@Test
	void testAddUser() {
		User testUser = new User("testingAdd", "1234", "ROLE_LEAD");
		testUser = userService.addUser(testUser);

		User getUser = userService.getUserById(testUser.getUserId());
		boolean returnStatment= false;

		if (getUser.toString().equals(testUser.toString())){
			returnStatment=true;
		}

		userService.deleteUserById(testUser.getUserId());
		assertTrue(returnStatment);
	}
	@Test
	void testUpdateUser() {
		String name = "updateUser";
		User updateUser = new User(userid, "updateUser", "1234", "ROLE_LEAD");

		userService.updateUser(updateUser);

		User getUser = userService.getUserById(u.getUserId());

		assertEquals(name,getUser.getUsername());
	}
	@Test
	void testDisableUserById() {

		userService.disableUserById(u.getUserId());

		User getUser = userService.getUserById(u.getUserId());

		assertEquals(false,getUser.isEnabled());
	}

}
