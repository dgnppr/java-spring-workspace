package me.dgpr.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dgpr.data.EventType;
import me.dgpr.service.CouponService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CouponEventScheduler {

    private final CouponService couponService;

    @Scheduled(fixedDelay = 1000)
    private void chickenEventScheduler() {
        if (couponService.isEventEnd()) {
            log.info("===== 선착순 쿠폰 이벤트가 종료되었습니다. =====");
            return;
        }
        log.info("===== 쿠폰 발행 =====");
        couponService.publish(EventType.CHICKEN);
        couponService.getRemainingRequestOrder(EventType.CHICKEN);
    }
}
