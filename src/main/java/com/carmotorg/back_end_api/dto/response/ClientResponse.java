package com.carmotorg.back_end_api.dto.response;

import com.carmotorg.back_end_api.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record ClientResponse(

        @JsonProperty("id")
        UUID externalId,

        @JsonProperty("first_name")
        String firstName,

        @JsonProperty("last_name")
        String lastName,

        String cellphone,

        String email,

        String cpf,

        @JsonProperty("birth_date")
        Date birthDate,

        @JsonProperty("created_at")
        LocalDateTime createdAt,

        @JsonProperty("modified_at")
        LocalDateTime modifiedAt,

        Set<VehicleResponse> vehicles,

        Set<AddressResponse> address
) {
    public ClientResponse(Client client) {
        this(
                client.getExternalId(),
                client.getFirstName(),
                client.getLastName(),
                client.getCellphone(),
                client.getEmail() == null ? null : client.getEmail(),
                client.getCpf() == null ? null : client.getCpf(),
                client.getBirthDate() == null ? null : client.getBirthDate(),
                client.getCreatedAt(),
                client.getModifiedAt() == null ? null : client.getModifiedAt(),
                client.getVehicles().stream().map(VehicleResponse::new).collect(Collectors.toSet()),
                client.getAddresses() == null ? null : client.getAddresses().stream().map(AddressResponse::new).collect(Collectors.toSet())
        );
    }
}
