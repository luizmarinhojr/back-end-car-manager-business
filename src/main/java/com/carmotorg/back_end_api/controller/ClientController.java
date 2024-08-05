package com.carmotorg.back_end_api.controller;

import com.carmotorg.back_end_api.dto.request.ClientRequest;
import com.carmotorg.back_end_api.dto.response.ClientResponse;
import com.carmotorg.back_end_api.service.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.created(URI.create("/clients/" + clientResponse.externalId())).body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<Page<ClientResponse>> listAll(@PageableDefault(
            size = 15, sort = {"modifiedAt"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ClientResponse> clientResponse = service.listAll(pageable);
        return ResponseEntity.ok(clientResponse);
    }
}
