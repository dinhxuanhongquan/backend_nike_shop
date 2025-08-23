package com.example.backend_nike_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String wishlistId;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    LocalDateTime createdAt;
}
