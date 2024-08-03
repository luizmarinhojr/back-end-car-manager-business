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
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="services")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ServiceCategory serviceCategory;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal price;

    @UuidGenerator
    @Column(name = "external_id", nullable = false, unique = true)
    private UUID externalId;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @OneToMany(mappedBy = "service")
    private Set<OrderService> orderServices;
}
