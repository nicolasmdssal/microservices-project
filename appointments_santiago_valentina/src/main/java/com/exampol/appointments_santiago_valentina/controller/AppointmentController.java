package com.exampol.appointments_santiago_valentina.controller;

import com.exampol.appointments_santiago_valentina.model.Appointment;
import com.exampol.appointments_santiago_valentina.repository.AppointmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentRepository repository;

    @GetMapping
    public Flux<Appointment> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Appointment> getById(@PathVariable UUID id) {
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Appointment> create(@RequestBody @Valid Appointment appointment) {
        return repository.save(appointment); // sin setId
    }


    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return repository.deleteById(id);
    }
}

