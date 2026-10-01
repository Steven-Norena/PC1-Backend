package com.backend.pc1.dto.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RegistrationResponseDTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponseDTO {

    private Long id;
    private Long eventId;
    private String eventTitle;
    private String ticketType;
    private String attendeeUsername;
    private String status;
}
