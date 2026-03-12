package org.example;
import org.example.entity.Student;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
public class secondLevelCacheApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session1 = HibernateUtil.getSessionFactory().openSession();
		Student s1 = session1.get(Student.class, 1);
		System.out.println(s1);
		session1.close();

		System.out.println("First session done");

		Session session2 = HibernateUtil.getSessionFactory().openSession();
		Student s2 = session2.get(Student.class, 1);
		System.out.println(s2);
		session2.close();

		System.out.println("Second session done");


	}
}
