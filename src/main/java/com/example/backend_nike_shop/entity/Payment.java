package com.example.backend_nike_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payments")
@SQLDelete(sql = "UPDATE payments SET deleted = true WHERE paymentId = ?")
@Where(clause = "deleted = false")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String paymentId;

    @OneToOne
    @JoinColumn(name = "orderId")
    Order order;

    String paymentMethod;
    LocalDateTime paymentDate;
    Double amount;
    String transactionStatus;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;
}
