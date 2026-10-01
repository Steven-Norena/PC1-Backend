package com.backend.pc1.dto.event;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventRequestDTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDTO {

    private String title;

    private String description;

    private String category;

    private ZonedDateTime eventDate;

    private String location;
}
