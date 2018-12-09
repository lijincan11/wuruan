package com.example.demo.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Rsp;
import com.example.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	Rsp rsp=new Rsp();

	/**
	 * status  0:success  1:username or password not right  2:username  not exist
	 * @param user
	 * @return
	 */
	public Rsp login(User user) {
		// TODO Auto-generated method stub
		
		
		//num =1  表示 用户名存在
		int num=userDao.countUserName(user.getUsername());
		
		if(num==1){
			int num2=userDao.login(user);
			if(num2==1){
				rsp.setStatus(0);
				rsp.setTip("登陆成功");
			}else{
				rsp.setStatus(1);
				rsp.setTip("用户名或者密码不正确");
			}
		}else{
			rsp.setStatus(2);
			rsp.setTip("用户名不存在");
//			rsp.setData(null);
		}
		
		
		return rsp;
	}
	/**
	 * status 0: 注册成功        1:username or password is null  2:username or id is exit
	 * @param user
	 * @return
	 */
	public Rsp register(User user) {
		//num =1  表示 用户名和id存在
			int num=userDao.countNameandId(user.getUsername(), user.getId());
				
			if(num==1){
				rsp.setStatus(1);
				rsp.setTip("该ID或者用户名已被注册");
				}else{
					userDao.insertUser(user);
					rsp.setStatus(0);
					rsp.setTip("注册成功");
			}
			if(num==2){
				rsp.setStatus(2);
				rsp.setTip("注册信息不能为空");
			}
			return rsp;
	}
}
