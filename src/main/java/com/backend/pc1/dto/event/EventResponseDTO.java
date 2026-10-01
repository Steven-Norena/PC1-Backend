package com.backend.pc1.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * EventResponseDTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDTO {

    private Long id;
    
    private String organizerUsername;

    private String title;

    private String category;

    private String status;
}
