package com.carmotorg.back_end_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subtotal_products", nullable = false, precision = 13, scale = 2)
    private BigDecimal subtotalProducts;

    @Column(name = "subtotal_services", nullable = false, precision = 13, scale = 2)
    private BigDecimal subtotalServices;

    @Column(name = "discount_products", nullable = false, precision = 13, scale = 2)
    private BigDecimal discountProducts;

    @Column(name = "discount_services", nullable = false, precision = 13, scale = 2)
    private BigDecimal discountServices;

    @Column(name = "total_products", nullable = false, precision = 13, scale = 2)
    private BigDecimal totalProducts;

    @Column(name = "total_services", nullable = false, precision = 13, scale = 2)
    private BigDecimal totalServices;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal total;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;

    @OneToOne(mappedBy = "payment")
    private Order order;
}
