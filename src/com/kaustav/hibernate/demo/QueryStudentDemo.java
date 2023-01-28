package com.kaustav.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
		 		  
		  session.beginTransaction();
		  
		  //query all student
		  List<Student> students = session.createQuery("from Student").list();
		  
		  for(Student student:students) {
			  System.out.println(student);
		  }
		  
		  
		  
		  
		  session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
