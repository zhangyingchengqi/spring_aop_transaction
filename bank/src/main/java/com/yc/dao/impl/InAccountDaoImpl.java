package com.yc.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.InAccount;
import com.yc.dao.InAccountDao;

@Repository
public class InAccountDaoImpl implements InAccountDao {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addInAccount(InAccount inAccount) {
		this.jdbcTemplate.update("insert into inaccount values(?,?)", inAccount.getAccountid(), inAccount.getInbalance());
	}

}
