package com.backend.pc1.dto.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * GetEventResponseDTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatchEventResponseDTO {

    private Long id;

    private String title;

    private String status;
}
