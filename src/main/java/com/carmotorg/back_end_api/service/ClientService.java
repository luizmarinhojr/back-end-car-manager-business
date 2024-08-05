package com.carmotorg.back_end_api.service;

import com.carmotorg.back_end_api.dto.request.VehicleRequest;
import com.carmotorg.back_end_api.model.Vehicle;
import com.carmotorg.back_end_api.repository.ClientRepository;
import com.carmotorg.back_end_api.dto.request.ClientRequest;
import com.carmotorg.back_end_api.dto.response.ClientResponse;
import com.carmotorg.back_end_api.model.Address;
import com.carmotorg.back_end_api.repository.AddressRepository;
import com.carmotorg.back_end_api.model.Client;
import com.carmotorg.back_end_api.repository.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final VehicleRepository vehicleRepository;

    public ClientService(ClientRepository clientRepository,
                         AddressRepository addressRepository,
                         VehicleRepository vehicleRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public ClientResponse register(ClientRequest clientRequest) {
        Client client = clientRepository.save(new Client(clientRequest));
        client.addVehicle(registerVehicle(clientRequest.vehicle(), client));
        if (clientRequest.address().cep() != null) {
            client.addAddress(addressRepository.save(new Address(clientRequest.address(), client)));
        }
        return new ClientResponse(client);
    }

    public Page<ClientResponse> listAll(Pageable pageable) {
        Page<Client> client = clientRepository.findAllClients(pageable);
        return client.map(ClientResponse::new);
    }

    private Vehicle registerVehicle(VehicleRequest vehicleRequest, Client client) {
        return vehicleRepository.save(new Vehicle(vehicleRequest, client));
    }

}
