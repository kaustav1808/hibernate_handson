package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Student.class)
				                     .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// using transaction start	
			  session.beginTransaction();
			  
			  //query all students
			  int id = 5;
			  Student student = session.get(Student.class,id);
			  
			  student.setFirstName("zachary");
			  
			  session.getTransaction().commit();
			  // using transaction end
			  
			  session = factory.getCurrentSession();
			  session.beginTransaction();
			  int result = session.createQuery("UPDATE Student set last_name= 'zajjjdelll' where id=5")
					           .executeUpdate();
			  System.out.println("query result: "+ result);
			  session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
