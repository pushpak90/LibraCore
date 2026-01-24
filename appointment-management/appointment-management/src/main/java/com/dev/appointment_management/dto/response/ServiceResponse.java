package com.dev.appointment_management.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Integer durationInMinutes;
    private boolean active;
}
