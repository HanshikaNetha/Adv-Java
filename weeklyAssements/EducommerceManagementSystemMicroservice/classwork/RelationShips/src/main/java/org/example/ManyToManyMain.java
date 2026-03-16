package org.example;
import org.example.ManyToMany.Course;
import org.example.ManyToMany.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Arrays;
import java.util.Scanner;
public class ManyToManyMain {
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
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Session session=sessionfactory.openSession();
		Transaction tnx=session.beginTransaction();
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("Enter course1 name: ");
		String c1=sc.nextLine();
		System.out.println("Enter course2 name: ");
		String c2=sc.nextLine();
		Course cou1=new Course(c1);
		Course cou2=new Course(c2);
		Student s=new Student(name, Arrays.asList(cou1, cou2));
		cou1.setStudents(Arrays.asList(s));
		cou2.setStudents(Arrays.asList(s));
		session.persist(s);
		tnx.commit();
		session.close();
		System.out.println("Data is entered");
	}

}
