package com.example.backend_nike_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String orderItemId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @ManyToOne
    @JoinColumn(name = "variantId")
    ProductVariant variant;

    Integer quantity;
    Double price;
}
