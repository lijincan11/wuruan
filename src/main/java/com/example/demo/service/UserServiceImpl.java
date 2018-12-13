package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Rsp;
import com.example.demo.model.RspStatus;
import com.example.demo.model.TokenFactory;
import com.example.demo.model.User;
import static com.example.demo.util.UUIDUtil.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	/**
	 * 登陆
	 * @throws UnsupportedEncodingException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public Rsp login(User user) throws Exception {
		String token=TokenFactory.createToken(getOne(user));
		return exist(user)?Rsp.Success("登陆成功").setData(token):Rsp.Fail(RspStatus.NO_AUTH, "用户名或者密码不正确");
	}

	/**
	 * 注册
	 */
	@Override
	public Rsp register(User user) {

//		if (isRegistered(user)) {
//			return Rsp.Fail("该用户名已被注册");
//		} else {
//			if (addUser(user)) {
//				return Rsp.Success("注册成功");
//			} else {
//				return Rsp.Fail("注册失败");
//			}
//		}
		user.setRole_id("GENERAL_USER");
		return !isRegistered(user)?(addUser(user)?
				Rsp.Success("注册成功"):Rsp.Fail("注册失败")):Rsp.Fail("该用户名已被注册");

	}

	/**
	 * 判断用户是否存在
	 */
	@Override
	public boolean exist(User user) {
		return userDao.exist(user)==1;
	}

	/**
	 * 判断用户名是否背注册
	 */
	@Override
	public boolean isRegistered(User user) {
		User temp =new User();
		temp.setUsername(user.getUsername());
		user=null;//置空  让jvm 可以进行垃圾回收
		return exist(temp);
	}

	/**
	 * 向数据库添加一个用户
	 */
	@Override
	public boolean addUser(User user) {
		user.setId(randomString());
		return userDao.add(user)==1;
	}

	@Override
	public User getOne(User user) {
		// TODO Auto-generated method stub
		return userDao.getOne(user);
	}

	@Override
	public List<User> getSome(User user) {
		// TODO Auto-generated method stub
		return userDao.getSome(user);
	}
}
