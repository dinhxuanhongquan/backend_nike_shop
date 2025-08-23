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
@Table(name = "shipping")
@SQLDelete(sql = "UPDATE shipping SET deleted = true WHERE shippingId = ?")
@Where(clause = "deleted = false")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String shippingId;

    @OneToOne
    @JoinColumn(name = "orderId")
    Order order;

    String carrier;
    String trackingNumber;
    String shippingStatus;

    LocalDateTime estimatedDelivery;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;
}
