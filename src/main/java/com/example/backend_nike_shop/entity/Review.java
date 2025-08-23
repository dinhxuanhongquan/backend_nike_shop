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
@Table(name = "reviews")
@SQLDelete(sql = "UPDATE reviews SET deleted = true WHERE reviewId = ?")
@Where(clause = "deleted = false")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String reviewId;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    @ManyToOne
    @JoinColumn(name = "userId")
    User user;

    Integer rating;
    String comment;
    LocalDateTime createdAt;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;
}
