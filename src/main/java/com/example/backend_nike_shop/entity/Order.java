package com.example.backend_nike_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
@SQLDelete(sql = "UPDATE orders SET deleted = true WHERE orderId = ?")
@Where(clause = "deleted = false")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String orderId;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    String orderStatus;
    String paymentStatus;
    String shippingAddress;
    Double totalPrice;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<OrderItem> items;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Payment payment;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    Shipping shipping;
}
