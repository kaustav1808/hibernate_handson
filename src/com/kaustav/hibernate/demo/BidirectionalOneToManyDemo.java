package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Course;
import com.kaustav.hibernate.demo.entity.Instructor;
import com.kaustav.hibernate.demo.entity.InstructorDetail;
import com.kaustav.hibernate.demo.entity.Review;

public class BidirectionalOneToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Course course = session.get(Course.class, 12 );
			
			System.out.println(course);
			
			System.out.println(course.getReviews());
			
			session.getTransaction().commit();

			System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
