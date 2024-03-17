package com.example.banking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	List<Account> findByOwnerName(String ownerName);
	Optional<Account> findByAccountNumber(String accountNumber);
	

}
