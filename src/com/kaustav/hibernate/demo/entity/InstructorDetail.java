package com.kaustav.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	public InstructorDetail() {
		
	}
	
	

	public InstructorDetail(String youtubechannel, String hobby) {
		this.youtubechannel = youtubechannel;
		this.hobby = hobby;
	}


    @Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubechannel;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructor_detail", cascade=CascadeType.ALL)
	private Instructor instructor;

	
	
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubechannel=" + youtubechannel + ", hobby=" + hobby + "]";
	}



	public Instructor getInstructor() {
		return instructor;
	}



	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getYoutubechannel() {
		return youtubechannel;
	}



	public void setYoutubechannel(String youtubechannel) {
		this.youtubechannel = youtubechannel;
	}



	public String getHobby() {
		return hobby;
	}



	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
}
