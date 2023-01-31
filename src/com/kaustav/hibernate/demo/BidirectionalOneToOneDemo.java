package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Instructor;
import com.kaustav.hibernate.demo.entity.InstructorDetail;

public class BidirectionalOneToOneDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			InstructorDetail detail = session.get(InstructorDetail.class, 2);
			
			System.out.println(detail);
			
			System.out.println(detail.getInstructor());

			session.getTransaction().commit();

			System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
