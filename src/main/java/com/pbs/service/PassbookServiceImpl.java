package com.pbs.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;

import com.pbs.dao.IPassbookDao;
import com.pbs.exception.PassbookException;

public class PassbookServiceImpl implements IPassbookService {
	@Autowired
	IPassbookDao daoPassbook;

	@Override
	public List<Transaction> updatePassbook(long accountId) throws PassbookException  {
		List<Transaction> transactionList = daoPassbook.updatePassbook(accountId);
		System.out.println(transactionList);
		if(transactionList.isEmpty()) throw new PassbookException("No Transaction Found");
		else 
			return transactionList;
	}
	
	@Override
	public List<Transaction> accountSummary(long accountId,LocalDate startDate,LocalDate endDate){
		return daoPassbook.accountSummary(accountId, startDate, endDate);
	}
}