package com.yc.biz;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.dao.UserDao;


@Service
//@Scope("prototype")
//@Lazy
public class UserBizImpl implements UserBiz {
	
	@Resource(name="userDaoJdbcImpl")  //  @Autowired @Qualified("userDaoJdbcImpl")       //@Autowired         @Primary
	private UserDao userDao;    //     boolean exists        boolean isExists()    setExists()
	
	@PostConstruct
	public void init() {
		System.out.println("调用了userBizImpl的   init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("调用了UserBizImpl的destroy ");
	}
	
	public UserBizImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public UserBizImpl() {
		System.out.println("UserBizImpl的无参构造方法");
	}
	
	

	public void addUser(    String uname,String pwd  ) {   //添加 :  addXxx   insertXxx    tianJiaUser   
		userDao.addUser();
	}

	public void deleteUser() {   //   deleteXxx   delXxx   removeXxx
		userDao.deleteUser();
	}

	public void updateUser() {
		userDao.updateUser();
		//throw new RuntimeException("出异常了");

	}

	public double findUser() {
		userDao.findUser();
		
		return Math.random();
	}

}
