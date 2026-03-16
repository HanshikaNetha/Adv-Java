package org.example;

import java.util.List;
import java.util.Scanner;

import org.example.entity.Student;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {
    	
    	Scanner sc=new Scanner(System.in);
//    	System.out.println("Enter Student id: ");
//    	int id=sc.nextInt();
//    	sc.nextLine();
//    	System.out.println("Enter Studetn name: ");
//    	String name=sc.nextLine();
//    	System.out.println("Enter Student age: ");
//    	int age=sc.nextInt();

        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

//        Transaction tx = session.beginTransaction();

//        Student s = new Student(101, "Hanshika", 21);
//        Student s=new Student( name, age);

//        session.persist(s);
        //or session.save(s);
//        Student stu=session.get(Student.class, 2);
//        if(stu!=null) {
//        	System.out.println(stu);
//        }else {
//        	System.out.println("there is no data with id 2");
//        }
        while(true) {
        	System.out.println("1->add \n2->view \n3->update \n4->delete \n5->stop");
        	int choice=sc.nextInt();
        	sc.nextLine();
        	switch(choice) {
        	case 1:
        		System.out.println("Enter name");
        		String name=sc.nextLine();
        		System.out.println("Enter age");
        		int age=sc.nextInt();
        		Transaction tx1=session.beginTransaction();
        		Student s=new Student(name, age);
        		session.save(s);
        		tx1.commit();
        		System.out.println("added student");
        		break;
        	case 2:
        		System.out.println("what do you want \n1-> id \n2->name \n3->all");
        		int choice1=sc.nextInt();
        		sc.nextLine();
        		switch(choice1) {
        		case 1:
        			System.out.println("Enter id");
        			int id=sc.nextInt();
        			Student s1=session.get(Student.class, id);
        			if(s1!=null) {
        				System.out.println(s1);
        			}else {
        				System.out.println("No data");
        			}
        			break;
        		case 2:
        			System.out.println("Enter name: ");
        			String nam=sc.nextLine();
        			List<Student> list=session.createQuery("from student where name=:n",Student.class).setParameter("n",nam).list();
        			if(!list.isEmpty()) {
        				for(Student i: list) {
        					System.out.println(i);
        				}
        			}else {
        				System.out.println("no data");
        			}
        			break;
        		case 3:
        			
        			List<Student> list1=session.createQuery("from Student", Student.class).list();
        			if(!list1.isEmpty()) {
        				for(Student i: list1) {
        					System.out.println(i);
        				}
        			}else {
        				System.out.println("Empty");
        			}
        			break;
        		}
        		break;
        	case 3:
        		System.out.println("Enter id where to update: ");
        		int id_update=sc.nextInt();
        		sc.nextLine();
        		Student upstu=session.get(Student.class, id_update);
        		if(upstu!=null) {
//        			System.out.print("Enter name: ");
//        			String upname=sc.nextLine();
//        			System.out.println("enter age");
//        			int upage=sc.nextInt();
//        			sc.nextLine();
//        			Transaction tx2=session.beginTransaction();
//        			upstu.setName(upname);
//        			upstu.setAge(upage);
//        			tx2.commit();
        			
        			System.out.println("what would you like to update 1->name \n2->age \nboth");
        			int upchoice=sc.nextInt();
        			sc.nextLine();
        			Transaction tx2=session.beginTransaction();
        			switch(upchoice){
        				case 1:
        					System.out.println("write new name to update");
        					String upname=sc.nextLine();
        					upstu.setName(upname);
        					break;
        				case 2:
        					System.out.println("Write age new to update");
        					int upage=sc.nextInt();
        					upstu.setAge(upage);
        					break;
        				case 3:
        					System.out.println("write new name to update:") ;
        					String uppname=sc.nextLine();
        					System.out.println("Write age new to update: ");
        					int uppage=sc.nextInt();
        					upstu.setName(uppname);
        					upstu.setAge(uppage);
        					break;
        			}
        			tx2.commit();;
        			System.out.println("updated the student");
        		}else {
        			System.out.println("student not there");
        		}
        		break;
        	case 4:
        		System.out.println("which is should be deleted: ");
        		int delid=sc.nextInt();
        		sc.nextLine();
        		Student studel=session.get(Student.class, delid);
        		if(studel!=null) {
        			Transaction tx3=session.beginTransaction();
        			session.delete(studel);
        			tx3.commit();
        			System.out.println("student is deleted");
        		}else {
        			System.out.println("Student not there");
        		}
        		break;
        	default:
        		System.out.println("Invalid choice");
        	case 5:
        		
        		sc.close();
        		System.out.println("done with everthing bye bye ");
        		return;
        	}
        }

//        tx.commit();
//        session.close();
//        sc.close();

//        System.out.println("Student saved successfully!");
    }
}
