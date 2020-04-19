package bank;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.yc.AppConfig;
import com.yc.bean.Account;
import com.yc.dao.AccountDao;
import com.yc.dao.InAccountDao;

@RunWith(SpringJUnit4ClassRunner.class)   // 请导入    spring-test包
@ContextConfiguration(classes = {AppConfig.class})    //IOC
public class TestJdbc {

	@Autowired      //  DI  
	@Qualifier("dataSource")
	private DriverManagerDataSource dmd;
	
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private InAccountDao inAccountDao;
	
	@Test   //这是一个测试用例
	public void testDataSource() throws SQLException {
		Assert.notNull(  dmd );
		System.out.println(     dmd.getConnection() );
	}
	
	
	@Test   //这是一个测试用例
	public void testAccountDao() throws SQLException {
		Account a=new Account();
		a.setAccountid(    "1"   );
		a.setBalance(1);
		accountDao.addAccount(a);
	}
	
}
