package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		  System.out.println("creating new student object");
		  Student student = new Student("Kaustav", "Bhattacharya", "kaustavofficial@outlook.com");
		  
		  session.beginTransaction();
		  
		  System.out.println("saving new student object");
		  session.save(student);
		  
		  session.getTransaction().commit();
		  
		  System.out.println("Success.");
		}finally {
			factory.close();
		}

	}

}
