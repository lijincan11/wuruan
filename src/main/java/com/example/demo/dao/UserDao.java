package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserDao {

	
//	@Select("select * from users")
//	List<User> getAllUser();
//	
//	
//	@Update("update users set username=#{username} ,password=#{password} where id=#{id}")
//	int updateUser(User user);
//	
//	
//	@Delete("delete from users where id=#{id}")
//	int deleteUser(User user);
//	
//	@Insert("insert into users values(#{username},#{password},#{id})")
//	int insertUser(User user);
//
//	@Select("select count(*) from users where username=#{username} and password=#{password}")
//	int login(User user);
//
//	//判断 这个用户名在数据库中是否存在
//	@Select("select count(*) from users where username=#{username}")
//	int countUserName(@Param("username") String dasdas);


	int exist(User user);
	
	int add(User user);
	
	
	
}
