package com.carmotorg.back_end_api.controller;

import com.carmotorg.back_end_api.dto.request.ClientRequest;
import com.carmotorg.back_end_api.dto.response.ClientResponse;
import com.carmotorg.back_end_api.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponse> register(@RequestBody @Validated ClientRequest clientRequest) {
        ClientResponse clientResponse = service.register(clientRequest);
        return ResponseEntity.created(URI.create("/")).body(clientResponse);
    }
}
