package com.yc.biz;

import com.yc.bean.Account;

public interface AccountBiz {
	
	public void open(   Account account );
	
	public Account find( String accountid );
	
	public Account deposite(  String accountid, double money );
	
	public Account deposite(  Account account );
	
	public Account withdraw(  String accountid, double money );
	
	public Account withdraw(  Account account );
	
	public Account transfer(  String accountid,  double money,   String inAccountId );
}
