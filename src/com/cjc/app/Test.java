package com.cjc.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cjc.configue.HibernateUtil;

import com.cjc.model.Employee;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session1 = sf.openSession();

		Employee emp1 = session1.get(Employee.class, 101); // 1st hit

		Employee emp2 = session1.get(Employee.class, 101);

		Employee emp3 = session1.get(Employee.class, 101);

		Employee emp4 = session1.get(Employee.class, 102); // 2nd hit

		Employee emp5 = session1.get(Employee.class, 102);

		Session session2 = sf.openSession();

		Employee emp6 = session2.get(Employee.class, 101); // 3rd hit

		Employee emp7 = session2.get(Employee.class, 101);

		Employee emp8 = session2.get(Employee.class, 102); // 4th hit

		Employee emp9 = session2.get(Employee.class, 102);

	}

	private static void insertData(Session session) {
		Employee emp1 = new Employee(101, "Vinod", 50000.00);
		Employee emp2 = new Employee(102, "Aman", 52000.00);
		Employee emp3 = new Employee(103, "Sanskriti", 45000.00);
		Employee emp4 = new Employee(104, "Priya", 60000.00);
		Employee emp5 = new Employee(105, "Saurabh", 20000.00);

		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);

		session.beginTransaction().commit();

		System.out.println("Done...!");
	}

}
