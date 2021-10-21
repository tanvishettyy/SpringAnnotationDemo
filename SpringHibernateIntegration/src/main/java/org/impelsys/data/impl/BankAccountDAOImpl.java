package org.impelsys.data.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.impelsys.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Transactional
//@Repository
public class BankAccountDAOImpl {
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveOrUpdate(BankAccount bankAccount)
	{
		Session session =sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(bankAccount);
		tx.commit();
		session.close();
	}
	
	public int add(BankAccount bankAccount)
	{
		return 0;
		
	}
	
	public boolean delete(BankAccount bankAccount)
	{
		return true;
	}
	
	public List<BankAccount> getAllBankAccounts()
	{
		Session session =sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Query<BankAccount> query= session.createQuery("from BankAccount",BankAccount.class);
		List<BankAccount> listAccounts=query.list();
		return listAccounts;
	}
}
