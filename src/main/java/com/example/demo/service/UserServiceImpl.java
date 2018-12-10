package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.util.StringUtils.*;

import com.example.demo.dao.UserDao;
import com.example.demo.model.Rsp;
import com.example.demo.model.RspStatus;
import com.example.demo.model.User;
import static com.example.demo.util.UUIDUtil.*;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;

	/**
	 * status 0:success 1:username or password not right 2:username not exist
	 * 
	 * @param user
	 * @return
	 */
	public Rsp login(User user) {
		// num =1 表示 用户名存在
//		int num = userDao.countUserName(user.getUsername());

		if (exist(user)) {
			int num2 = userDao.login(user);
			if (num2 == 1) {
				return Rsp.Success("登陆成功");
			} else {
				return Rsp.Fail("用户名或者密码不正确");
			}
		} else {
			return Rsp.Fail(RspStatus.NO_AUTH, "用户名不存在");
		}

	}

	/**
	 * status 0: 注册成功 1:username or password is null 2:username or is exit
	 * 3:注册失败
	 * 
	 * @param user
	 * @return
	 */
	public Rsp register(User user) {
		Rsp rsp = new Rsp();
		// num =1 表示 用户名和id存在
		int num = userDao.countUserName(user.getUsername());

		if (isEmpty(user.getUsername()) || isEmpty(user.getPassword())) {
			rsp.setStatus(2);
			rsp.setTip("注册信息不能为空");
			return rsp;
		}

		if (num == 1) {
			rsp.setStatus(1);
			rsp.setTip("该用户名已被注册");
		} else {
			user.setId(randomString());
			int num2 = userDao.insertUser(user);

			if (num2 == 1) {
				rsp.setStatus(0);
				rsp.setTip("注册成功");
			} else {
				rsp.setStatus(3);
				rsp.setTip("注册失败");
			}

		}

		return rsp;
	}

	@Override
	public boolean exist(User user) {
		// TODO Auto-generated method stub
		return userDao.exist(user)==1;
	}
}
