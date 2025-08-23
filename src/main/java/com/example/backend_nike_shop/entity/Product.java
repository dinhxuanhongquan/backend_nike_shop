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
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted = true WHERE productId = ?")
@Where(clause = "deleted = false")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String productId;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    Category category;

    String productName;
    Double price;
    String brand;
    Integer stockQuantity;
    Double discountPrice;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ProductImage> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<ProductVariant> variants;

    @OneToMany(mappedBy = "product")
    Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    Set<CartItem> cartItems;

    @OneToMany(mappedBy = "product")
    Set<Review> reviews;
}
