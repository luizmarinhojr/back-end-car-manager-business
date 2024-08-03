package com.carmotorg.back_end_api.model;

import com.carmotorg.back_end_api.dto.request.AddressRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    private String complement;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String country;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    public Address(AddressRequest addressInput, Client client) {
        this.client = client;
        this.cep = addressInput.cep();
        this.street = addressInput.street();
        this.number = addressInput.number();
        this.complement = addressInput.complement();
        this.neighborhood = addressInput.neighborhood();
        this.city = addressInput.city();
        this.state = addressInput.state();
        this.country = addressInput.country();
    }
}
