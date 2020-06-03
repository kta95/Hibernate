package com.kta.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.kta.hibernate.demo.entity.Course;
import com.kta.hibernate.demo.entity.Instructor;
import com.kta.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			int theId = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from  Instructor i"
							+ "JOIN FETCH i.course where i.id =:theInstructorId", Instructor.class);
			
			//set parameter on query
			query.setParameter("theInstructorId",theId);
			
			// execute query and get instructor
			Instructor temp = query.getSingleResult();
			

			//commit the transaction
			session.getTransaction().commit();
			System.out.println("KTA code : Instructor : "+ temp);

			System.out.println("KTA code : transaction completed!");
		} finally {
			session.close();
			factory.close();
		}		
	}

}
