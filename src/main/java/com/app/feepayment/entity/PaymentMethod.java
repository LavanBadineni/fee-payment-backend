package com.app.feepayment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentMethodId;

    @Column(nullable = false)
    private String methodName;

    @OneToMany(mappedBy = "paymentMethod")
    private Set<Payment> payments;

    // Getters and Setters
}
