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
@Table(name = "coupons")
@SQLDelete(sql = "UPDATE coupons SET deleted = true WHERE couponId = ?")
@Where(clause = "deleted = false")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String couponId;

    @Column(unique = true)
    String code;

    Double discountPercent;
    Double discountAmount;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Integer usageLimit;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<OrderCoupon> orderCoupons;

    @Column(name = "deleted", nullable = false)
    boolean deleted = false;
}
