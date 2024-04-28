package com.example.letsmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letsmeet.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
