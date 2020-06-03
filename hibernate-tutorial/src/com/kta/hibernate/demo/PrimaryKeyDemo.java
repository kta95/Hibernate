package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kta.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			//create 3 student objects
			System.out.println("creating 3 student...");
			
			Student student1 = new Student("Thant Phyo", "Aung", "tpa@email");
			Student student2 = new Student("Arkar", "Hein", "akh@email");
			Student student3 = new Student("Su", "mo", "sm@email");
			
			//begin transaction
			session.beginTransaction();
			//save the objects in session
			System.out.println("saving the students..");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//commit the session
			session.getTransaction().commit();
			System.out.println("commited!");
			//create new 
			
			System.out.println("primary key : "+student2.getId());
			
			//get new session
			session = factory.getCurrentSession();
			//begin transaction first
			session.beginTransaction();
			//read the role via id
			Student newStudent = session.get(Student.class, student2.getId());
			System.out.println(newStudent);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}
		
		
	}

}
