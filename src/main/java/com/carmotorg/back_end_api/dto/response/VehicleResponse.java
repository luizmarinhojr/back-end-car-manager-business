package com.carmotorg.back_end_api.dto.response;

import com.carmotorg.back_end_api.model.Vehicle;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record VehicleResponse(

        @JsonProperty("id")
        UUID externalId,

        @JsonProperty("license_plate")
        String licensePlate,

        String brand,

        String model,

        String year,

        @JsonProperty("fipe_price")
        BigDecimal fipePrice,

        @JsonProperty("created_at")
        LocalDateTime createdAt,

        @JsonProperty("modified_at")
        LocalDateTime modifiedAt
) {
    public VehicleResponse(Vehicle vehicle) {
        this(
                vehicle.getExternalId(),
                vehicle.getLicensePlate(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getYear(),
                vehicle.getFipePrice(),
                vehicle.getCreatedAt(),
                vehicle.getModifiedAt()
        );
    }
}
