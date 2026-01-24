package com.dev.appointment_management.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateServiceRequest {
    @NotBlank
    private String name;
    private String description;
    @Min(1)
    private Integer durationInMinutes;
}
