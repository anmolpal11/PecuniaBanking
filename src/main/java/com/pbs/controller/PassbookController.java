package com.pbs.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pbs.exception.PassbookException;
import com.pbs.service.IPassbookService;

public class PassbookController {
	@Autowired
	IPassbookService service;
	
	@GetMapping("transactions/{accountId}")
	public ResponseEntity<List<Transaction>> updatePassbook(@PathVariable long accountId) throws PassbookException{
		try {
				List<Transaction> transactionList = service.updatePassbook(accountId);
				return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
		} catch(PassbookException transactionsNotFoundException) {
			    throw new PassbookException(transactionsNotFoundException.getMessage());
		}
	}

	@GetMapping("transactions/search")
	public List<Transaction> accountSummary(long accountId, LocalDate startDate, LocalDate endDate){
		return service.accountSummary(accountId, startDate, endDate);
	}
}