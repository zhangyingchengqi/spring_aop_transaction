package com.yc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages="com.yc")
@EnableTransactionManagement
public class AppConfig {

	@Bean    //      id: dataSource    value:  DriverManagerDataSource
	public  DriverManagerDataSource   dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:HELOWIN");
		dataSource.setUsername("scott");
		dataSource.setPassword("a");
		return dataSource;
	}
	
	@Bean
	@Autowired
	public    DataSourceTransactionManager  tx(  DriverManagerDataSource ds    ){
		DataSourceTransactionManager dtm=new DataSourceTransactionManager();
		//AnnotationTransactionAspect.aspectOf().setTransactionManager(dtm);  //表示当前的  tx 事务管理器是mo认的  @Transaction的事务管理器
		dtm.setDataSource(   ds );
		return dtm;
	}
	
//	//@Bean
//	public  DriverManagerDataSource   mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/bank");
//		dataSource.setUsername("root");
//		dataSource.setPassword("a");
//		return dataSource;
//	}
	
	
}
