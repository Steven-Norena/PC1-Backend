package com.backend.pc1.model;

import java.time.ZonedDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventRegistration
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long eventId;

    private Long ticketTypeId;
    
    private Long attendeeId;

    @Builder.Default
    private ZonedDateTime registeredAt = ZonedDateTime.now();

    @Builder.Default
    private String status = "CONFIRMED";
}
