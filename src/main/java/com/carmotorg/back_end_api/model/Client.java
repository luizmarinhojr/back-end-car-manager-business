package com.carmotorg.back_end_api.model;

import com.carmotorg.back_end_api.dto.request.ClientRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="clients")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String cellphone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    private Date birthDate;

    @OneToMany(mappedBy = "client")
    private Set<Vehicle> vehicles;

    @OneToMany(mappedBy = "client")
    private Set<Address> addresses;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;


    public Client(ClientRequest clientInput) {
        this.firstName = clientInput.firstName();
        this.lastName = clientInput.lastName();
        this.cellphone = clientInput.cellphone();
        this.cpf = clientInput.cpf() == null ? null : clientInput.cpf();
        this.birthDate = clientInput.birthDate() == null ? null : clientInput.birthDate();
        this.vehicles = new HashSet<>();
        if (clientInput.address() != null) {
            this.addresses = new HashSet<>();
        }
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }
}
