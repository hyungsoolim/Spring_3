package com.hs.s3.account;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hs.s3.MyAbstractTest;

public class AccountServiceTest extends MyAbstractTest {
	
	@Autowired
	private AccountService accountService;
	
	@Test
	public void setInsertTest() throws Exception {
		accountService.setInsert(null);
	}

	

}
