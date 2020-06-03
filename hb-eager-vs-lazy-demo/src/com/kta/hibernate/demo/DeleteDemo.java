package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// create  object
//			Instructor tempInstructor =
//					new Instructor("Chad", "Darby", "dar@luv2code.com");
		
			//begin transaction
			session.beginTransaction();
			int id = 2;
			//get the object from table by primary key
			Instructor tempInstructor = session.get(Instructor.class, id);
			System.out.println("The Instructor from table is : "+ tempInstructor);
			
			//delete that object along with the foreign key 
			if(tempInstructor != null) {
				System.out.println("Deleting the instructor : "+ tempInstructor);
				session.delete(tempInstructor);
			}
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			factory.close();
		}
		
		
	}

}
