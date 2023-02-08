package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Course;
import com.kaustav.hibernate.demo.entity.Instructor;
import com.kaustav.hibernate.demo.entity.InstructorDetail;
import com.kaustav.hibernate.demo.entity.Review;
import com.kaustav.hibernate.demo.entity.Student;

public class CreateManyToManyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			Course course = new Course("Advance Java.");
						
			session.save(course);
			
			Student student = new Student("Dev", "Maitra", "dev@outlook.com");
			Student student2 = new Student("Lina", "Dey", "lina@outlook.com");
			
			course.addStudent(student);
			course.addStudent(student2);
			
			session.save(student);
			session.save(student2);
			
			session.getTransaction().commit();

			System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
