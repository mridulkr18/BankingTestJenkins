package com.example.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking.dto.DepositRequestDto;
import com.example.banking.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/deposit")
	public String depositMoney(@RequestBody DepositRequestDto depositRequestDto) {
		accountService.deposit(depositRequestDto.getAccount_id(), depositRequestDto.getDepositAmount());
		;
		return "Successfully deposited";
	}

	@RequestMapping("/")
	public String home() {
		return "Hello World!";
	}

}
