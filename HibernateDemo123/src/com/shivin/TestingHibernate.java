package com.shivin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shivin.model.Student;

public class TestingHibernate {
	public static void main(String[] args) {

//step 1  : load config.xml file also known as create session factory.
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

// step 2 : open session.
		Session s = factory.openSession();

// step 3 : Begin Transaction.
		Transaction t = s.beginTransaction();

// step 4 : create objects for student table.
		//Student stud = new Student(1, "babu", "BackEnd");
		//Student stud1 = new Student(2, "raju", "Testing");

// step 5 : save Objects into session.
		//s.save(stud);
		//s.save(stud1);

// step 6 : save or commit the transaction.
		
		
		// lets read the rows from the table Student
		Student s1 = s.get(Student.class,3);
		if(s1!=null)
		{
		System.out.println(s1.getSno());
		System.out.println(s1.getSname());
		System.out.println(s1.getSubject());
		}
		else
		{
			System.out.println("no such student availble");
		}
		
 // get student where sno = 1, and change subject to "Java BackEnd Developer"
//		Student s2 = s.get(Student.class,1);
//		s2.setSubject("Java BackEnd Developer");
//		s.save(s2);
		// we can go to mysql workbench and select * from student
//		t.commit();// for every update,delete and create we need to commit transaction otherwise it couldn't update data

// delete sno= 2
		Student s2 = s.get(Student.class,2);
		s.delete(s2);
		t.commit();
		

// step 7 : close session.
		s.close();

// step 8 : close factory.
		factory.close();

	}
}
