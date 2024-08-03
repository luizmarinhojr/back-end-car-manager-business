package com.carmotorg.back_end_api.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public record ClientRequest(
        @JsonAlias("first_name")
        @NotEmpty(message = "First name can't be empty")
        @Length(max = 30, message = "First name to long")
        String firstName,

        @JsonAlias("last_name")
        @NotEmpty(message = "Last name can't be empty")
        @Length(max = 30, message = "Last name to long")
        String lastName,

        @NotEmpty(message = "Cellphone can't be empty")
        @Length(max = 15, message = "Invalid cellphone")
        String cellphone,

        @Email(message = "Invalid email")
        String email,

        @CPF(message = "Invalid CPF")
        String cpf,

        @JsonAlias("birth_date")
        @Length(max = 35)
        Date birthDate,

        @NotNull
        VehicleRequest vehicle,

        AddressRequest address
) {
}
