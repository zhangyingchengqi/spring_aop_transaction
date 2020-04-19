package com.yc.biz;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class UserBizImpl implements UserBiz {

	public void addUser(String uname, String pwd) {
		System.out.println("添加用户");
	}

	public void deleteUser() {
		System.out.println("删除用户");
	}

	public void updateUser() {
		System.out.println("更新用户");

	}

	public double findUser() {
		System.out.println("查询用户");
		return Math.random();
	}

}
