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
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String cartItemId;

    @ManyToOne
    @JoinColumn(name = "cartId")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @ManyToOne
    @JoinColumn(name = "variantId")
    ProductVariant variant;

    Integer quantity;
}
