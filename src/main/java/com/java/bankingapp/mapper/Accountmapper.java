package com.java.bankingapp.mapper;

import com.java.bankingapp.dto.AccountDto;
import com.java.bankingapp.entity.Account;

public class Accountmapper {

	public static Account mapToAccount(AccountDto accountDto) {
		
		Account account= new Account(
				        
				           accountDto.getId(),
				           accountDto.getAccountHolderName(),
				           accountDto.getBalance());
		
	 return account;
	}
				
				 
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance());
				
		 return accountDto;
	}			
		
}
