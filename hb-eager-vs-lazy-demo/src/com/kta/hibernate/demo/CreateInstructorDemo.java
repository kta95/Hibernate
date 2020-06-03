package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create  object
			Instructor tempInstructor =
					new Instructor("Kyaw Thet", "Aung", "kta@kmail.com");
			
//			Instructor tempInstructor =
//					new Instructor("JavaBrains", "Koushik", "koushik@javabrains.com");
			InstructorDetail tempInterstructorDetail =
					new InstructorDetail("http://www.kta.com/youtube", "doing nothing!!");
			
			tempInstructor.setInstructorDetail(tempInterstructorDetail);
			//associate the objects
			System.out.println("creating object.....");
			
			
			//begin transaction
			session.beginTransaction();
			
			//save the instructor in session
			session.save(tempInstructor);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			factory.close();
		}
		
		
	}

}
