package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.User;

@Mapper
public interface UserDao {

	
	@Select("select * from users")
	List<User> getAllUser();
	
	
	@Update("update users set username=#{username} ,password=#{password} where id=#{id}")
	int updateUser(User user);
	
	
	@Delete("delete from users where id=#{id}")
	int deleteUser(User user);
	
	@Insert("insert into users values(#{username},#{password},#{id})")
	int insertUser(User user);
	
	
}
