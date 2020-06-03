package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;
import com.kta.hibernate.demo.entity.Review;
import com.kta.hibernate.demo.entity.Student;

public class CreateCourseForKyawThetDemo {

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
			// get Kyaw Thet from student database
			
			int theId = 1;
			Student student = session.get(Student.class, theId);
			System.out.println("Information of Kyaw Thet" + student);
			System.out.println("KTA's courses: "+ student.getCourses());
			// create a course
			Course tempCourse1 = new Course("How to Fap - zero to hero");
			Course tempCourse2 = new Course("How to fart loudly");
			
			student.addCourse(tempCourse1);
			student.addCourse(tempCourse2);
			
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
