package com.kaustav.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	public Instructor() {
		
	}
	


	public Instructor(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructor_detail;

	public InstructorDetail getInstructor_detail() {
		return instructor_detail;
	}



	public void setInstructor_detail(InstructorDetail instructor_detail) {
		this.instructor_detail = instructor_detail;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", instructor_detail=" + instructor_detail + "]";
	}

	
	
}
