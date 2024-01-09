package me.dgpr.service;

import static me.dgpr.config.RedisConfig.FIRST_ELEMENT;
import static me.dgpr.config.RedisConfig.LAST_ELEMENT;
import static me.dgpr.config.RedisConfig.LAST_INDEX;
import static me.dgpr.config.RedisConfig.PUBLISH_SIZE;

import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dgpr.data.CouponEvent;
import me.dgpr.data.EventType;
import me.dgpr.data.UserCoupon;
import me.dgpr.utils.TimeUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Getter
@Slf4j
@RequiredArgsConstructor
@Service
public class CouponService {

    private final RedisTemplate<String, String> couponRedisTemplate;
    private CouponEvent couponEvent;

    public void setEventCount(EventType eventType, int size) {
        this.couponEvent = new CouponEvent(eventType, size);
    }

    public void enqueueCouponIssueRequest(EventType eventType, String userId) {
        long currentTimeMillis = TimeUtils.currentTimeMillis();
        couponRedisTemplate.opsForZSet().add(eventType.getName(), userId, currentTimeMillis);
        log.info("대기열에 요청 추가 - [{}] ({})", userId, currentTimeMillis);
    }

    public void getRemainingRequestOrder(EventType eventType) {
        Set<String> couponIssueRequestQueue = couponRedisTemplate.opsForZSet()
                .range(eventType.toString(), FIRST_ELEMENT, LAST_ELEMENT);

        if (Objects.isNull(couponIssueRequestQueue) || CollectionUtils.isEmpty(couponIssueRequestQueue)) {
            return;
        }

        for (String userId : couponIssueRequestQueue) {
            Long rank = couponRedisTemplate.opsForZSet().rank(eventType.getName(), userId);
            log.info("'{}'님의 현재 대기열은 {}명 남았습니다.", userId, rank);
        }
    }

    public void publish(EventType eventType) {
        final long start = FIRST_ELEMENT;
        final long end = PUBLISH_SIZE - LAST_INDEX;

        Set<String> couponIssueRequestQueue = couponRedisTemplate.opsForZSet().range(eventType.getName(), start, end);

        if (Objects.isNull(couponIssueRequestQueue) || CollectionUtils.isEmpty(couponIssueRequestQueue)) {
            return;
        }

        for (String userId : couponIssueRequestQueue) {
            UserCoupon userCoupon = new UserCoupon(eventType);
            log.info("'{}'님에게 {} 쿠폰이 발급되었습니다 ({})", userId, eventType.getName(), userCoupon.getCode());
            couponRedisTemplate.opsForZSet().remove(eventType.getName(), userId);
            this.couponEvent.decrease();
        }
    }

    public boolean isEventEnd() {
        return Objects.isNull(this.couponEvent) ? false : this.couponEvent.isEnd();
    }

    public long getRemainingSize(EventType eventType) {
        return couponRedisTemplate.opsForZSet().size(eventType.getName());
    }
}
