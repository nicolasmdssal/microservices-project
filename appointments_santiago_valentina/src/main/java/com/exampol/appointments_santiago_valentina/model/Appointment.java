package com.exampol.appointments_santiago_valentina.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("appointments")
public class Appointment {
    @Id
    private UUID id;

    private Long userId;

    @NotNull
    private LocalDateTime date;

    @NotBlank
    private String doctor;

    private String notes;
}

