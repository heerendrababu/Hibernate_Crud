package com.shivin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.shivin.demo.Employee;

public class EmployeeMainClass 
{

	public static void main(String[] args) 
	{

       // 1 - load config.xml file
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	// 2 - open Session
	Session s = factory.openSession();
	
// 3 - begin Transaction.
	
  Transaction t = s.beginTransaction();
  
 // 4 - C-- create objects for student table.
//	Employee e1 = new Employee(1, "babu", 25000);
//	Employee e2 = new Employee(2, "raju",30000);
	
// 5 - save object
	
//	s.save(e1); // insert first object as first row
//	s.save(e2); // insert second object as second row

  
 // R-- lets read the rows from the table employee
 // each object e, e1 will become rows into table
  
  Employee e = s.get(Employee.class,1);
  System.out.println(e.getEno());
  System.out.println(e.getEname());
  System.out.println(e.getEsal());
  
  Employee e1 = s.get(Employee.class,2);
  System.out.println(e1.getEno());
  System.out.println(e1.getEname());
  System.out.println(e1.getEsal());

// U -- update row from the table.
  Employee y= s.get(Employee.class, 1);
  y.setEsal(900000);
  s.save(y);
  
 // D-- delete row from the table.
  Employee d = s.get(Employee.class,2);
  s.delete(d);
// 6 - commit transaction
	
	t.commit();
	
	// step 7 : close session.
			s.close();

	// step 8 : close factory.
			factory.close();
	}

}
