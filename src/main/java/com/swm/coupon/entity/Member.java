package com.swm.coupon.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {

    @Id
    private String id;
}
