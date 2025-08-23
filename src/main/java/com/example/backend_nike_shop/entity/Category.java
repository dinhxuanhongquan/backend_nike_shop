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
@Table(name = "categories")
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE categoryId = ?")
@Where(clause = "deleted = false")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String categoryId;

    String categoryName;
    String categoryDescription;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    String image; // Base64

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category")
    Set<Product> products;
}
