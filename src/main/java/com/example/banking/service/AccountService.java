	package com.example.banking.service;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.banking.entity.Account;
import com.example.banking.kafka.KafkaProducer;
import com.example.banking.repository.AccountRepository;
	
	@Service
	public class AccountService {
	
		@Autowired
		private AccountRepository accountRepository;
//	
//		@Autowired
//		private KafkaProducer kafkaProducer;
	
		public void deposit(Long accountId, double amount) {
			Account account = accountRepository.findById(accountId).orElse(null);
			if (account != null) {
				double currentBalance = account.getBalance();
				account.setBalance(currentBalance + amount);
				accountRepository.save(account);
//				kafkaProducer.publishAccountActivityEvents("deposit made to the account successfully");
			}
		}
	
		public void withdraw(Long accountId, double amount) {
			Account account = accountRepository.findById(accountId).orElse(null);
			if (account != null) {
				double currentBalance = account.getBalance();
				if (currentBalance >= amount) {
					account.setBalance(currentBalance - amount);
					accountRepository.save(account);
//					kafkaProducer.publishAccountActivityEvents(
//							"Withdrawal made from account " + accountId + ": Amount - " + amount);
				} else {
					System.out.println("Insufficient balance");
				}
			}
		}
	
		// Method to check balance of an account
		public double checkBalance(Long accountId) {
			Account account = accountRepository.findById(accountId).orElse(null);
			return (account != null) ? account.getBalance() : 0.0;
		}
	}
