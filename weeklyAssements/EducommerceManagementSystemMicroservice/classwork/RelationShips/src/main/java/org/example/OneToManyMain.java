package org.example;
import java.util.Scanner;
//import javax.persistence.*;
import org.example.OneToMany.Passport;
import org.example.OneToMany.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
public class OneToManyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		while(true) {
			System.out.println("1.Add Person & Passort");
			System.out.println("2.see data by person id");
			System.out.println("3.see data by passportId");
			System.out.println("4.Exit");
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter person name: ");
				String name=sc.nextLine();
				System.out.println("Enter Passport Number: ");
				String passportNumber=sc.nextLine();
				System.out.println("Enter country: ");
				String country=sc.nextLine();
				Session session=factory.openSession();
				Transaction tx=session.beginTransaction();
				Passport passport=new Passport(passportNumber, country);
				Person person=new Person(name, passport);
				session.save(person);
				tx.commit();
				session.close();
				System.out.println("Person and Passport saved successfully");
				break;
			case 4:
				factory.close();
				sc.close();
				System.out.println("we are done ");
				return;
			case 2:
				System.out.println("Enter person id of data  you want: ");
				int personid=sc.nextInt();
				Session session2=factory.openSession();
				Person p1=session2.get(Person.class, personid);
				if(p1!=null) {
					System.out.println("PersonID: "+p1.getPersonId()+"PersonNAme: "+p1.getPersonName()+"PassportId: "+p1.getPassport().getPassportId()+"PassportNumber: "+p1.getPassport().getPassportNumber()+"country: "+p1.getPassport().getCountry());
				}else {
					System.out.println("Person not found");
				}
				session2.close();
				break;
			case 3:
				System.out.println("Enter Passort ID: ");
				int passportId=sc.nextInt();
				Session session3=factory.openSession();
				Passport p2=session3.get(Passport.class, passportId);
				if(p2!=null) {
					System.out.println("Passort ID: "+p2.getPassportId()+"PassportNumber: "+p2.getPassportNumber()+"country: "+p2.getCountry()+"PersonID: "+p2.getPerson().getPersonId()+"PersonNAme: "+p2.getPerson().getPersonName());
				}else {
					System.out.println("Passprort not there");
				}
				session3.close();
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

	}

}
