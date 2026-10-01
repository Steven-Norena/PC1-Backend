package com.backend.pc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pc1.model.TicketType;

/**
 * TicketTypeRepository
 */
public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {

    
}
