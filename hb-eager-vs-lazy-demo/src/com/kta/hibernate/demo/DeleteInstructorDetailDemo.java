package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			//begin transaction
			session.beginTransaction();
			//get the object from table by primary key
			int theId = 4;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("deleting: "+instructorDetail);
			
			//break the link to instructor table
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			System.out.println("Instructor : "+instructorDetail.getInstructor());

			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
