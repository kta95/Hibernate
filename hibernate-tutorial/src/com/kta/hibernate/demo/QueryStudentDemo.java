package com.kta.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					//begin transaction
					session.beginTransaction();
					//query the students
					List<Student> students = session.createQuery("from Student").getResultList();
					//display all students			
					extracted(students);
					
					System.out.println("\n\n\n");
					//query the student to get student by last name
					students = session.createQuery("from Student s where s.lastName = 'Aung'").getResultList();
					extracted(students);
					
					System.out.println("\n\n\n");
					students = session.createQuery("from Student s where s.lastName = 'Aung' and s.firstName='Kyaw Thet'").getResultList();
					extracted(students);

					System.out.println("\n\n\n");
					students = session.createQuery("from Student s where s.email like '%email'").getResultList();
					extracted(students);
					
					//commit the transaction
					session.getTransaction().commit();
					
					System.out.println("transaction completed!");
				} finally {
					factory.close();
				}
				
	}

	public static void extracted(List<Student> students) {
		for(Student temp : students) {
			System.out.println(temp);
		}
	}

}
