package com.pbs.dao;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transaction;

public class PassbookDaoImpl implements IPassbookDao {
	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaction> updatePassbook(long accountId) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from Transaction t where t.account_id=:accountId");
		query.setParameter("accountId",accountId);
		return query.getResultList();
		
	}

	@Override
	public List<Transaction> accountSummary(long accountId, LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select t from Transaction t where t.account_id=:accounId AND t.transaction_date BETWEEN :startDate AND endDate");
		query.setParameter("accountId", accountId);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}
	

}