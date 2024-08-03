package com.carmotorg.back_end_api.dto.response;

import com.carmotorg.back_end_api.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record AddressResponse(

        @JsonProperty("id")
        UUID externalId,

        String cep,

        String street,

        String number,

        String complement,

        String neighborhood,

        String city,

        String state,

        String country
) {
    public AddressResponse(Address address) {
        this(
                address.getExternalId(),
                address.getCep(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement() == null ? null : address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getCountry() == null ? "Brasil" : address.getCountry()
        );
    }
}
