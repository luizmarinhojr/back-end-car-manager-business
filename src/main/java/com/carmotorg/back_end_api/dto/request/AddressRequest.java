package com.carmotorg.back_end_api.dto.request;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public record AddressRequest(

        @NotEmpty(message = "CEP can't be empty")
        @Length(min = 9, max = 9, message = "CEP is too long")
        String cep,

        @NotEmpty(message = "Street can't be empty")
        @Length(max = 30, message = "Street is too long")
        String street,

        @NotEmpty(message = "Number can't be empty")
        @Length(max = 10, message = "Number is too long")
        String number,

        @Length(max = 30, message = "Complement is too long")
        String complement,

        @NotEmpty(message = "Neighborhood can't be empty")
        @Length(max = 30, message = "Neighborhood is too long")
        String neighborhood,

        @NotEmpty(message = "City can't be empty")
        @Length(max = 30, message = "City is too long")
        String city,

        @NotEmpty(message = "State can't be empty")
        @Length(max = 30, message = "State is too long")
        String state,

        @Length(max = 30, message = "Country is too long")
        String country
) {
}
