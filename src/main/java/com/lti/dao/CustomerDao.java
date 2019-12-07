package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Customer;

public class CustomerDao {
	
	public void add(Customer customer) {

		//step 1.create/obtain EntityManagerFactory object
		//During this step, META-INF/persistence.xml file will be read
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("oracleTest");
		
		//step 2. create/obtain EntityManager();
		//This step is logically similar to opening Connection in JDBC code
		EntityManager em=emf.createEntityManager();
		
		//step 3. start/participate in a transaction 
		//DML operations cannot be performed without a transaction
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		//now we can insert /update/delete/select whatever we want
		em.persist(customer); //persist method generates insert query
		
		
		tx.commit();
		
		em.close();
		emf.close();
	}
	
	public Customer fetch(int customerId) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("oracleTest");
		
		EntityManager em=emf.createEntityManager();
		
		// find method generates select query with where condition. but condition should only be a primary key
		Customer cust=(Customer) em.find(Customer.class,customerId);
		
		em.close();
		emf.close();
		
		return cust;
	}
	
	public List<Customer> fetchAll(){
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("oracleTest");
		
		EntityManager em=emf.createEntityManager();
		
		//JPQL
		Query  q=em.createQuery("select c from Customer c");
		List<Customer> list=q.getResultList();
		
		em.close();
		emf.close();
		
		return list;
	}
	
	public void update(Customer customer) {

		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("oracleTest");
		
		
		EntityManager em=emf.createEntityManager();
		
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		
		em.merge(customer); //merge method generates update query
		
		
		tx.commit();
		
		em.close();
		emf.close();
	}
	
}
