package com.yc.dao;

import com.yc.bean.Account;

public interface AccountDao {
	
	public void addAccount(   Account account );
	
	public void updateAccount(  Account account);
	
	public Account findAccount(  String accountid );
}
