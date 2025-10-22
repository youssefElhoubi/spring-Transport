package com.transports.transport.DTOS;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.transports.transport.enums.DeliveryStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TourDto {
    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Tour date cannot be in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "Vehicle ID is required")
    private Long vehicleId;

    @NotNull(message = "Warehouse ID is required")
    private Long warehouseId;

    @NotNull(message = "Total distance is required")
    @Positive(message = "Total distance must be positive")
    private Double totalDistance;

    @NotNull(message = "Status is required")
    private DeliveryStatus status;

    // Optional: deliveries could be validated separately if provided
    private List<Long> deliveryIds;
}
