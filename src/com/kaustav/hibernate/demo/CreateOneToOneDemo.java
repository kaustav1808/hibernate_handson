package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Instructor;
import com.kaustav.hibernate.demo.entity.InstructorDetail;

public class CreateOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Instructor instructor = new Instructor("Kaustav", "Bhattacharya", "kasutav.bhattacharya@email.com");
			
			InstructorDetail detail = new InstructorDetail("https://www.youtube.com/watch?v=lKKsjpH09dU&ab_channel=freeCodeCamp.org", "coding");
			
			instructor.setInstructor_detail(detail);
			
			session.save(instructor);

			session.getTransaction().commit();

			System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
