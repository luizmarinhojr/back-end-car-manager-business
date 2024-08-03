package com.carmotorg.back_end_api.model;

import com.carmotorg.back_end_api.dto.request.VehicleRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="license_plate", nullable = false, unique = true)
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String year;

    @Column(name = "fipe_price", precision = 13, scale = 2, nullable = false)
    private BigDecimal fipePrice;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "vehicle")
    private Set<Order> orders;

    public Vehicle(VehicleRequest vehicleRequest, Client client) {
        this.licensePlate = vehicleRequest.licensePlate();
        this.brand = vehicleRequest.brand();
        this.model = vehicleRequest.model();
        this.year = vehicleRequest.year();
        this.fipePrice = vehicleRequest.fipePrice();
        this.client = client;
    }
}
