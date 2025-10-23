package com.exampol.appointments_santiago_valentina.repository;

import com.exampol.appointments_santiago_valentina.model.Appointment;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface AppointmentRepository extends R2dbcRepository<Appointment, UUID> {
    Flux<Appointment> findByUserId(UUID userId);
}

