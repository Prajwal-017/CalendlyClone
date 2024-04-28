package com.example.letsmeet.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//Package: com.example.entity
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime appointmentDateTime;

	@ManyToOne
	private User user;

	private String location; // Location type: Zoom, Google Meet, In-person

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Appointment(Long id, LocalDateTime appointmentDateTime, User user, String location) {
		super();
		this.id = id;
		this.appointmentDateTime = appointmentDateTime;
		this.user = user;
		this.location = location;
	}

	public Appointment() {
		super();
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentDateTime=" + appointmentDateTime + ", user=" + user
				+ ", location=" + location + "]";
	}

	// Constructors, getters, setters, and any additional fields or methods can be
	// added here
}