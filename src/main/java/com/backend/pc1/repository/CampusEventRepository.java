package com.backend.pc1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pc1.model.CampusEvent;

/**
 * CampusEventRepository
 */
public interface CampusEventRepository extends JpaRepository<CampusEvent, Long> {

    
}
