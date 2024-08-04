package com.carmotorg.back_end_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @Column(name = "estimated_service_days")
    private Integer estimatedDaysToService;

    @Column(name = "estimated_vehicle_receipt")
    private LocalDateTime estimatedVehicleReceipt;

    @Column(name = "estimated_service_start")
    private LocalDateTime estimatedServiceStart;

    @Column(name = "estimated_service_completion")
    private LocalDateTime estimatedServiceCompletion;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "order")
    private Set<OrderService> orderServices;

    @OneToMany(mappedBy = "order")
    private Set<OrderProduct> orderProducts;
}
