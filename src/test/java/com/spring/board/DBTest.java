package com.spring.board;


import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:dbconfig/mybatis-context.xml")
public class DBTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	void connTest() {
		System.out.println("datasource......"+dataSource);
	}

}
