 package org.example;
import java.util.Arrays;

import org.example.ManyToOne.Department;
import org.example.ManyToOne.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class ManyToOneMain {

		// TODO Auto-generated method stub
	private static final SessionFactory sessionfactory=buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		catch(Exception e) {
			throw new RuntimeException("sessionfactory is not able to create", e);
		}
	}
	public static void main(String[] args) {
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Department d=new Department("IT");
		Employee e1=new Employee("Gui", d);
		Employee e2=new Employee("Tim", d);
		d.setEmployees(Arrays.asList(e1, e2));
		session.persist(d);
		session.persist(e1);
		session.persist(e2);
		transaction.commit();
		session.close();
		System.out.println("data is sent indide");
	}

}
