package com.swm.coupon;

import com.swm.coupon.entity.Coupon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {
    private final CouponService couponService;
    CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    // 쿠폰 생성
    @PostMapping
    public ResponseEntity<Object> createCoupon(
            @RequestPart String memberId,
            @RequestPart String couponType,
            @RequestPart String expiresAt,
            @RequestPart Integer count) {
        couponService.createCoupon(memberId, couponType, expiresAt, count);
        return ResponseEntity.ok("쿠폰 생성이 완료 되었습니다.");
    }


    // 쿠폰 발급
    @PostMapping("/issue")
    public ResponseEntity<Object> issueCoupon(
            @RequestPart String memberId,
            @RequestPart Long couponId) {
        couponService.issueCoupon(memberId, couponId);
        return ResponseEntity.ok("쿠폰 발급이 완료되었습니다.");
    }


    // 쿠폰 사용
    @PostMapping("/use")
    public ResponseEntity<Object> useCoupon(
            @RequestPart String memberId,
            @RequestPart Long couponId) {
        couponService.useCoupon(memberId, couponId);
        return ResponseEntity.ok("쿠폰 사용이 완료되었습니다.");
    }


    // 쿠폰 확인
    @GetMapping
    public ResponseEntity<List<Coupon>> getCoupons() {
        List<Coupon> coupons = couponService.getCoupons();
        return ResponseEntity.ok(coupons);
    }
}
