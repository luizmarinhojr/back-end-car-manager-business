package com.carmotorg.back_end_api.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record VehicleRequest(

        @JsonAlias("license_plate")
        @NotEmpty(message = "License plate can't be empty")
        @Length(min = 8, max = 8, message = "License Plate is too long or too short")
        String licensePlate,

        @NotEmpty(message = "Brand can't be empty")
        @Length(max = 35, message = "Brand is too long")
        String brand,

        @NotEmpty(message = "License plate can't be empty")
        @Length(max = 35, message = "Model is too long")
        String model,

        @NotEmpty(message = "Year can't be empty")
        @Length(max = 30, message = "Year is too long")
        String year,

        @JsonAlias("fipe_price")
        @NotEmpty(message = "Fipe price can't be empty")
        BigDecimal fipePrice
) {
}
