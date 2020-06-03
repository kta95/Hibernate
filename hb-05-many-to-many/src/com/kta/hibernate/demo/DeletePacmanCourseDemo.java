package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;
import com.kta.hibernate.demo.entity.Review;
import com.kta.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			// get pacman course from database
			
			int theId = 20;
			Course tempCourse = session.get(Course.class,theId);
			
			System.out.println("Deleting the course: "+ tempCourse);
			session.delete(tempCourse);
			System.out.println("deleted the course: "+ tempCourse);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
