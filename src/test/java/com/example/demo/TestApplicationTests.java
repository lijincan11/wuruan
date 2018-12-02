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

}
