package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			System.out.println("creating 3 new students object");
			Student student = new Student("Zac", "zajdell", "zaczajdell@outlook.com");
			Student student2 = new Student("tanner", "campbell", "tannercampbell@outlook.com");
			Student student3 = new Student("brad", "ryba", "bradryba@outlook.com");

			session.beginTransaction();

			System.out.println("saving 3 new students object");
			session.save(student);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();

			System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
