package com.swm.coupon;

import com.swm.coupon.entity.Coupon;
import com.swm.coupon.repository.CouponIssueRepository;
import com.swm.coupon.repository.CouponRepository;
import com.swm.coupon.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final CouponIssueRepository couponIssueRepository;
    private final MemberRepository memberRepository;

    public void createCoupon(
            String memberId,
            String couponType,
            String expiresAt,
            Integer count) {

    }

    public void issueCoupon(
            String memberId,
            Long couponId) {

    }

    public void useCoupon(
            String memberId,
            Long couponId) {

    }

    public List<Coupon> getCoupons() {

        return null;
    }

    public LocalDateTime validateAndParse(String dateStr) {
        // YYYY:MM:DD 패턴 확인 후 LocalDateTime 생성
        Pattern DATE_PATTERN = Pattern.compile("^\\d{4}:\\d{2}:\\d{2}$");
        if (dateStr == null || !DATE_PATTERN.matcher(dateStr).matches()) return null;

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            LocalDate date = LocalDate.parse(dateStr, formatter);
            return LocalDateTime.of(date, LocalTime.MIDNIGHT);
        } catch (DateTimeParseException e) {
            // 형식은 맞지만 유효하지 않은 날짜인 경우 (예: 2023:02:31)
            return null;
        }
    }
}
