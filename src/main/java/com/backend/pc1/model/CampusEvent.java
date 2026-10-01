package com.backend.pc1.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CampusEvent
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CampusEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long organizerId;

    @Column(nullable = false)
    private String title;

    @Size(min = 500)
    private String description;

    private String category;

    private ZonedDateTime eventDate;

    private String location;

    @Builder.Default
    private String status = "DRAFT";
}
