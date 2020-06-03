package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Student;

public class UpdateStudentDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			//begin transaction
			session.beginTransaction();
			

			Student newStudent = session.get(Student.class, studentId);
			System.out.println(newStudent);
			
			newStudent.setFirstName("Sai Thant Phyo");
			System.out.println(newStudent);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//new codes
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("Update Student set email = 'foo@gmail'").executeUpdate();
			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		
	}
}
