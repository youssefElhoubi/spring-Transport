package com.transports.transport.DTOS;

import com.transports.transport.enums.VehicleType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehiculDTO {
    @NotNull(message = "Vehicle type is required")
    private VehicleType type;

    @NotNull(message = "Maximum weight is required")
    @Positive(message = "Maximum weight must be positive")
    private Double maxWeight;

    @NotNull(message = "Maximum volume is required")
    @Positive(message = "Maximum volume must be positive")
    private Double maxVolume;

    @NotNull(message = "Maximum deliveries count is required")
    @Positive(message = "Maximum deliveries must be positive")
    private Double maxDeliveries;
}
