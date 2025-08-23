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
@Table(name = "order_coupons")
public class OrderCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String orderCouponId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    Order order;

    @ManyToOne
    @JoinColumn(name = "couponId")
    Coupon coupon;
}
