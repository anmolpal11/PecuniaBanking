package com.pbs.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transaction;

public interface IPassbookDao {
	
	List<Transaction> updatePassbook(long accountId);
	List<Transaction> accountSummary(long accountId, LocalDate startDate, LocalDate endDate);

}
