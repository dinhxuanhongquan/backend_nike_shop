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
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String imageId;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    String imageUrl;
    Boolean isMain;
}
