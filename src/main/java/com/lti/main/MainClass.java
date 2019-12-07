package com.lti.main;

import java.util.List;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class MainClass {
	
	public static void main(String[] args) {
		Customer c=new Customer();
		c.setName("vishal");
		c.setEmail("vish@lti");
		c.setCity("Mumbai");
//		
//		CustomerDao dao=new CustomerDao();
//		dao.add(c);
		CustomerDao dao=new CustomerDao();
//		Customer c=dao.fetch(21);
//		System.out.println(c.getName());
//		System.out.println(c.getEmail());
//		System.out.println(c.getCity());
//		List<Customer> list=dao.fetchAll();
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).getId());
//			System.out.println(list.get(i).getName());
//			System.out.println(list.get(i).getEmail());
//			System.out.println(list.get(i).getCity());
//		}
//		
		 c=dao.fetch(21);
		 c.setCity("delhi");
		 dao.update(c);
	}
}
