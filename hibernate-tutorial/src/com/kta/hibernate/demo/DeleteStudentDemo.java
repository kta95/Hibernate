package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
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
			int studentId = 3;
			//begin transaction
			session.beginTransaction();
			
			session.createQuery("delete Student where id ='2'").executeUpdate();

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//new codes

		} finally {
			factory.close();
		}
		
		
	}
}
