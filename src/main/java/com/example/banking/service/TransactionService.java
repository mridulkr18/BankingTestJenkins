package com.example.banking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banking.entity.Account;
import com.example.banking.entity.Transaction;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	public Transaction recordTransaction(Transaction transaction) {
		// Save the transaction record
		Transaction savedTransaction = transactionRepository.save(transaction);

		// Update account balances based on the transaction details
		updateAccountBalances(transaction);

		return savedTransaction;
	}

	private void updateAccountBalances(Transaction transaction) {
		Long fromAccountId = transaction.getFromAccount().getId();
		Long toAccountId = transaction.getToAccount().getId();
		double amount = transaction.getAmount();

		Optional<Account> optionalFromAccount = accountRepository.findById(fromAccountId);
		Optional<Account> optionalToAccount = accountRepository.findById(toAccountId);

		if (optionalFromAccount.isPresent() && optionalToAccount.isPresent()) {
			Account fromAccount = optionalFromAccount.get();
			Account toAccount = optionalToAccount.get();

			// Update balances
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);

			// Save updated accounts
			accountRepository.save(fromAccount);
			accountRepository.save(toAccount);
		}
	}
}
