package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;
import com.kta.hibernate.demo.entity.Review;
import com.kta.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			System.out.println("\n Saving the course.....");
			session.save(tempCourse);			
			System.out.println("Saved the course : "+tempCourse);
			// create the student objects
			Student student1 = new Student("Kyaw Thet","Aung", "kta@kmail.com");
			Student student2 = new Student("Thant Phyo","Aung", "tpa@tmail.com");
			// add student to session
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			// save the students
			System.out.println("\n Saving the students....");
			session.save(student1);
			session.save(student2);
		//	System.out.println("saved the student : "+tempCourse.getStudents());
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("transaction completed!");
		} finally {
			session.close();
			factory.close();
		}
		
		
	}

}
