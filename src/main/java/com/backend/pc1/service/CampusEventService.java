package com.backend.pc1.service;

import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.backend.pc1.dto.PageResponseDTO;
import com.backend.pc1.dto.event.EventRequestDTO;
import com.backend.pc1.dto.event.EventResponseDTO;
import com.backend.pc1.dto.event.EventResponseDTO2;
import com.backend.pc1.dto.event.GetEventResponseDTO;
import com.backend.pc1.dto.event.PatchEventResponseDTO;
import com.backend.pc1.exception.EventNotFoundException;
import com.backend.pc1.model.CampusEvent;
import com.backend.pc1.model.User;
import com.backend.pc1.repository.CampusEventRepository;

import lombok.AllArgsConstructor;

/**
 * CampusEventService
 */
@Service
@AllArgsConstructor
public class CampusEventService {

    private final CampusEventRepository campusEventRepository;

    public EventResponseDTO createEvent(EventRequestDTO request, User user) {
        CampusEvent campusEvent = CampusEvent.builder()
            .organizerId(user.getId())
            .title(request.getTitle())
            .description(request.getDescription())
            .category(request.getCategory())
            .eventDate(request.getEventDate())
            .location(request.getLocation())
            .build();

        CampusEvent savedEvent = campusEventRepository.save(campusEvent);

        return EventResponseDTO.builder()
            .id(savedEvent.getId())
            .organizerUsername(user.getUsername())
            .title(savedEvent.getTitle())
            .category(savedEvent.getCategory())
            .status(savedEvent.getStatus())
            .build();
    }

    public PatchEventResponseDTO publishEvent(Long id) {
        CampusEvent campusEvent = campusEventRepository.findById(id)
            .orElseThrow(() -> new EventNotFoundException("No se ha encontrado el evento"));

        campusEvent.setStatus("PUBLISHED");

        return PatchEventResponseDTO.builder()
            .id(campusEvent.getId())
            .title(campusEvent.getTitle())
            .status(campusEvent.getStatus())
            .build();
    }

    public PageResponseDTO<EventResponseDTO2> getEvents (Integer size, Integer page,
            String category, ZonedDateTime from) {
        return null;
    }
}
