package com.java.bankingapp.service.Impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.bankingapp.dto.AccountDto;
import com.java.bankingapp.entity.Account;
import com.java.bankingapp.mapper.Accountmapper;
import com.java.bankingapp.repository.AccountRepository;
import com.java.bankingapp.service.AccountService;

@Service
public class ServiceImpl implements AccountService{

	
	
	private AccountRepository accountRepository;
	
	@Autowired
	public ServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto accountDto) {

		        Account account = Accountmapper.mapToAccount(accountDto);
				Account savedAccount = accountRepository.save(account);
				
		        return Accountmapper.mapToAccountDto(savedAccount);
	}

	@Override
	public AccountDto getAccountById(Long id) {
		// TODO Auto-generated method stub
		Account account= accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exists"));
		return Accountmapper.mapToAccountDto(account);
	}

	@Override
	public AccountDto deposit(Long id, double amount) {

			Account account= accountRepository
					.findById(id)
					.orElseThrow(()->new RuntimeException("Account doesn't exists"));
			
			
			double total= account.getBalance() + amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return Accountmapper.mapToAccountDto(savedAccount);
		
	}

	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exists"));
		
		
		if(account.getBalance()<amount) {
			
			
			throw new RuntimeException("Insufficient Amount");
			
		}
		
		double total= account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount = accountRepository.save(account);
		return Accountmapper.mapToAccountDto(savedAccount);
		
		
		
		
	}

	@Override
	public List<AccountDto> getAllAccounts() {
List<Account> accounts= accountRepository.findAll();
return accounts.stream().map((account)->Accountmapper.mapToAccountDto(account))
		             .collect(Collectors.toList());

	}

	@Override
	public void deleteAccount(Long id) {
		Account account= accountRepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account doesn't exists"));
		accountRepository.deleteById(id);
		
	}

	
}
