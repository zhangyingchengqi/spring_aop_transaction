package com.yc.biz;

/**
* @author 张影 QQ:1069595532  WX:zycqzrx1
* @date Apr 19, 2020
*/
public class Test {

	public static void main(String[] args) {
		UserBizImpl ub=new UserBizImpl();
		ub.addUser("zy", "a");
		
		LogCglibProxy lcp=new LogCglibProxy();
		UserBizImpl ub2=(UserBizImpl) lcp.createProxy(ub);
		
		ub2.addUser("a", "b");
	}

}
