package com.yc.biz.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Account;
import com.yc.bean.InAccount;
import com.yc.biz.AccountBiz;
import com.yc.dao.AccountDao;
import com.yc.dao.InAccountDao;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
public class AccountBizImpl implements AccountBiz {
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private InAccountDao inAccountDao;

	@Override
	public void open(Account account) {
		//  accountid:   sequnece,     UUID,     
		String accountid=UUID.randomUUID().toString().substring(0,10);
		account.setAccountid(accountid);
		
		accountDao.addAccount(account);
		
		InAccount inAccount=new InAccount();
		inAccount.setAccountid(account.getAccountid());
		inAccount.setInbalance(account.getBalance());
		inAccountDao.addInAccount(inAccount);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Account find(String accountid) {
		return accountDao.findAccount(accountid);
	}

	@Override
	public Account deposite(String accountid, double money) {   //事务
		Account a=new Account();
		a.setAccountid(accountid);
		a.setBalance(money);
		return deposite(  a );
	}

	@Override
	public Account deposite(Account account) {   //事务
		Account a=accountDao.findAccount(account.getAccountid());   //数据库中的金额   读
		a.setBalance(     a.getBalance()+account.getBalance() );    // 计算存后的金额   
		accountDao.updateAccount(a);     //真正发出更新语句   更新account
		
		InAccount inAccount=new InAccount();
		inAccount.setAccountid(account.getAccountid());
		inAccount.setInbalance(account.getBalance());
		inAccountDao.addInAccount(inAccount);   //更新  inAccount
		
		return a;
	}

	@Override
	public Account withdraw(String accountid, double money) {
		Account a=new Account();
		a.setAccountid(accountid);
		a.setBalance(money);
		return withdraw(  a );
	}

	@Override
	public Account withdraw(Account account) {
		InAccount inAccount=new InAccount();
		inAccount.setAccountid(account.getAccountid());
		inAccount.setInbalance(     -account.getBalance()    );
		inAccountDao.addInAccount(inAccount); 
		
		Account a=accountDao.findAccount(account.getAccountid());
		//判断  a   balance是否够     100W
		a.setBalance(a.getBalance()-account.getBalance());   //负数
		
		accountDao.updateAccount(a); 
		
		
		
		return a;
	}

	@Override    //  1   99  ->  2    update   account set balance=balance+99  where accountid=2;       commit;
	public Account transfer(String accountid, double money, String inAccountId) {  //   con.setAutoCommit( false  );
		deposite(  inAccountId,   money   );  // 3
		Account a=withdraw( accountid, money  );   //3
		return a;
	}

}
