package com.spring.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AccountDAO {
	@Update("update cust_account set balance=balance-5000000 where accountNo='70-490-930'")
	void updateBalance1();
	
	@Update("update cust_account set balance=balance+5000000 where accountNo='70-490-911'")
	void updateBalance2();
}
