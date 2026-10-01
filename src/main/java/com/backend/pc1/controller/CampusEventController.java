package com.backend.pc1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.pc1.dto.event.EventRequestDTO;
import com.backend.pc1.dto.event.EventResponseDTO;
import com.backend.pc1.dto.event.PatchEventResponseDTO;
import com.backend.pc1.model.User;
import com.backend.pc1.service.CampusEventService;

import lombok.AllArgsConstructor;

/**
 * CampusEventController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/events")
public class CampusEventController {

    private final CampusEventService campusEventService;

    @PostMapping
    public ResponseEntity<EventResponseDTO> postEvent(@RequestBody EventRequestDTO dto,
            @AuthenticationPrincipal User user) {
            EventResponseDTO response = campusEventService.createEvent(dto, user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }


    @PatchMapping("/{eventId}/publish")
    public PatchEventResponseDTO patchEvent(@RequestParam Long eventId) {
        PatchEventResponseDTO response = campusEventService.publishEvent(eventId);
        return response;
    }
}
