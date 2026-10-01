package com.backend.pc1.service;

import org.springframework.stereotype.Service;

import com.backend.pc1.dto.registration.RegistrationResponseDTO;
import com.backend.pc1.exception.EventNotFoundException;
import com.backend.pc1.exception.TicketTypeFullException;
import com.backend.pc1.exception.TicketTypeNotFoundException;
import com.backend.pc1.model.CampusEvent;
import com.backend.pc1.model.EventRegistration;
import com.backend.pc1.model.TicketType;
import com.backend.pc1.model.User;
import com.backend.pc1.repository.CampusEventRepository;
import com.backend.pc1.repository.EventRegistrationRepository;
import com.backend.pc1.repository.TicketTypeRepository;

/**
 * EventRegistrationService
 */
@Service
public class EventRegistrationService {

    private EventRegistrationRepository eventRegistrationRepository;
    private TicketTypeRepository ticketTypeRepository;
    private CampusEventRepository campusEventRepository;

    public RegistrationResponseDTO createRegistration(Long ticketTypeId, User user) {
        TicketType ticketType = ticketTypeRepository.findById(ticketTypeId)
            .orElseThrow(() -> new TicketTypeNotFoundException("No se ha encontrado el ticket"));

        CampusEvent campusEvent = campusEventRepository.findById(ticketType.getId())
            .orElseThrow(() -> new EventNotFoundException("No se ha encontrado el evento"));

        if (!campusEvent.getStatus().equalsIgnoreCase("PUBLISHED")) {
            throw new RuntimeException("El evento no esta publicado");
        }

        if (ticketType.getRegisteredCount() >= ticketType.getCapacity()) {
            throw new TicketTypeFullException("No se puede realizar la operación");
        }

        EventRegistration eventRegistration = EventRegistration.builder()
            .eventId(campusEvent.getId())
            .ticketTypeId(ticketType.getId())
            .attendeeId(user.getId())
            .build();

        EventRegistration savedRegistration = eventRegistrationRepository.save(eventRegistration);

        return RegistrationResponseDTO.builder()
            .id(savedRegistration.getId())
            .eventId(savedRegistration.getEventId())
            .eventTitle(campusEvent.getTitle())
            .ticketType(ticketType.getName())
            .attendeeUsername(user.getUsername())
            .status(savedRegistration.getStatus())
            .build();
    }
}
