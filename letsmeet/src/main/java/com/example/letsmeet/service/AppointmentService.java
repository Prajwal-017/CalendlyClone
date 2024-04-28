package com.example.letsmeet.service;

import com.example.letsmeet.entity.Appointment;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    Appointment updateAppointment(Long id, Appointment appointment);

    boolean deleteAppointment(Long id);
}
