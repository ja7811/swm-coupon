package com.swm.coupon.entity;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class CouponIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
