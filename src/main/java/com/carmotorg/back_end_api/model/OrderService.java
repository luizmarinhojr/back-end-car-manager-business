package com.carmotorg.back_end_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="orders_services")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderService {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private String description;

    @Column(nullable = false)
    private Integer quantity;

    @Column(precision = 13, scale = 2)
    private BigDecimal discount;

    private Boolean paid;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;
}
