package com.example.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {

	
	@Autowired
	UserDao userDao;
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void test_getUsers(){
		List<User> userList=userDao.getAllUser();
		
		User user;
		for (int i = 0; i < userList.size(); i++) {
			user=userList.get(i);
			System.out.println("用户名："+user.getUsername()+"\t"+"密码："+user.getPassword()+"\t"+"id:"+user.getId());
		}
	}
	
	
	@Test
	public void test_UpdateUser(){
		User user=new User("marry", "888", "3");
		
		int num=userDao.updateUser(user);
		
		System.out.println(num==1?"成功":"失败");
	}

	
	@Test
	public void test_deleteuser(){
		User user=new User("marry", "888", "1");
		
		int num=userDao.deleteUser(user);
		
		System.out.println(num==1?"成功":"失败");
	}
	
	
	
	@Test
	public void test_adduser(){
		User user=new User("marry", "888", "1");
		
		int num=userDao.insertUser(user);
		
		System.out.println(num==1?"成功":"失败");
	}
}
