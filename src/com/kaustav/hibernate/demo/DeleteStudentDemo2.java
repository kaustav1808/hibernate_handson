package com.kaustav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kaustav.hibernate.demo.entity.Student;

public class DeleteStudentDemo2 {

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
			  int id = 4;
			  Student student = session.get(Student.class,id);
			  
			  session.delete(student);
			  
			  session.getTransaction().commit();
			  // using transaction end
			  
			  session = factory.getCurrentSession();
			  session.beginTransaction();
			  int result = session.createQuery("delete from Student where id in (6,7)")
					           .executeUpdate();
			  System.out.println("query result: "+ result);
			  session.getTransaction().commit();
		}finally {
			factory.close();
		}

	}

}
