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
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE userId = ?")
@Where(clause = "deleted = false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String userId;

    @Column(unique = true, nullable = false)
    String username;

    String password;
    String email;
    String phone;
    String address;
    String fullName;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;

    @ManyToMany
    Set<Role> roles;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Cart> carts;

    @OneToMany(mappedBy = "user")
    Set<Order> orders;

    @OneToMany(mappedBy = "user")
    Set<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Wishlist> wishlists;
}
