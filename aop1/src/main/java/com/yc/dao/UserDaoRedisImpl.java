package com.yc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoRedisImpl implements UserDao {

	@Override
	public void addUser() {
		String sql="";
		//  xxx.doUpdate();
		System.out.println("  redis  添加用户");
	}

	@Override
	public void deleteUser() {
		System.out.println("redis 删除用户");
	}

	@Override
	public void updateUser() {
		System.out.println("redis   修改用户");
	}

	@Override
	public void findUser() {
		System.out.println("redis   查询用户");
	}


}
