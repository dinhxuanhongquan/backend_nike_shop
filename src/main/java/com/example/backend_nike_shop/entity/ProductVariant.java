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
@Table(name = "product_variants")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String variantId;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    Integer size;
    Integer stockQuantity;
}
