package com.backend.pc1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pc1.model.EventRegistration;

/**
 * EventRegistrationRepository
 */
public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {

    Optional<EventRegistration> findByTicketTypeId(Long ticketTypeId);
}
