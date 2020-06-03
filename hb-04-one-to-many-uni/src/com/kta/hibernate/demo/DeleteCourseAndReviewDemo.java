package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;
import com.kta.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			// get the course
			int id = 10;
			
			Course tempCoures = session.get(Course.class, id);
			
			// print the course
			System.out.println(tempCoures);
			// print the course review
			System.out.println(tempCoures.getReviews());
	 
			//delete the course
			session.delete(tempCoures);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
