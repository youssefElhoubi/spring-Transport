package com.transports.transport.DTOS;

import com.transports.transport.enums.DeliveryStatus;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelivaryDto {
    @NotBlank(message = "address is required")
    private String address;

    @NotNull(message = "latitude is required")
    @DecimalMin(value = "-90.0", message = "Latitude must be greater than or equal to -90")
    @DecimalMax(value = "90.0", message = "Latitude must be less than or equal to 90")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    @DecimalMin(value = "-180.0", message = "Longitude must be greater than or equal to -180")
    @DecimalMax(value = "180.0", message = "Longitude must be less than or equal to 180")
    private Double longitude;

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight;

    @NotNull(message = "Volume is required")
    @Positive(message = "Volume must be positive")
    private Double volume;

    @NotBlank(message = "Preferred time slot is required")
    private String preferredTimeSlot;

    @NotNull(message = "Status is required")
    private DeliveryStatus status;

    @NotNull(message = "Sequence order is required")
    @Min(value = 1, message = "Sequence order must be at least 1")
    private Integer sequenceOrder;

    @NotNull(message = "Tour ID is required")
    private Long tourId;
}
