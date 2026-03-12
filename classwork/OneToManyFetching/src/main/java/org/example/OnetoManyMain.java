package org.example;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
public class OnetoManyMain {
	private static final SessionFactory sessionfactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e) {
			throw new RuntimeException("SessionFactory is not created", e);
		}
	}
	public static void main(String[] args) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Order o1=new Order(LocalDate.now());
		Order o2=new Order(LocalDate.now().minusDays(4));
		Customer c=new Customer();
		c.setName("gui");
		o1.setCustomer(c);
		o2.setCustomer(c);
		c.setOrders(Arrays.asList(o1, o2));
		session.persist(c);
		transaction.commit();
		session.close();
		System.out.println("Data is put inside");
	}
}
