package com.backend.pc1.dto.event;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventResponseDTO2
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO2 {

    private Long id;

    private String title;

    private String category;

    private ZonedDateTime eventDate;

    private Integer availableSlots;
}
