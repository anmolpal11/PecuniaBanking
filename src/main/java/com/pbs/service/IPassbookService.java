package com.pbs.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transaction;

import com.pbs.exception.PassbookException;

public interface IPassbookService {
	
	List<Transaction> updatePassbook(long accountId) throws PassbookException;
	List<Transaction> accountSummary(long accountId, LocalDate startDate, LocalDate endDate);
	
	
}