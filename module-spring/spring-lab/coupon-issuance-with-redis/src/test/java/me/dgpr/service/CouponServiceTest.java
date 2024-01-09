package me.dgpr.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;
import me.dgpr.data.EventType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class CouponServiceTest {

    @Autowired
    CouponService couponService;

    @Autowired
    RedisTemplate<String, String> couponRedisTemplate;

    @AfterEach
    void tearDown() {
        couponRedisTemplate.delete(EventType.CHICKEN.getName());
    }

    @Test
    @DisplayName("선착순 30명에게 쿠폰 발급 이벤트")
    void issueCoupon() throws Exception {
        //given
        final EventType chickenCouponEvent = EventType.CHICKEN;
        final int peopleNumber = 100;
        final int limitCount = 30;
        final CountDownLatch countDownLatch = new CountDownLatch(peopleNumber);

        couponService.setEventCount(chickenCouponEvent, limitCount);

        List<Thread> workers = Stream
                .generate(() -> new Thread(new AddQueueWorker(countDownLatch, chickenCouponEvent)))
                .limit(peopleNumber)
                .toList();

        //when
        workers.forEach(Thread::start);
        countDownLatch.await();
        Thread.sleep(5000); // 기프티콘 발급 스케줄러 작업 시간

        //then
        final long failEventPeople = couponService.getRemainingSize(chickenCouponEvent);
        Assertions.assertThat(failEventPeople).isEqualTo(peopleNumber - limitCount);

    }

    private class AddQueueWorker implements Runnable {
        private CountDownLatch countDownLatch;
        private EventType eventType;

        public AddQueueWorker(CountDownLatch countDownLatch, EventType eventType) {
            this.countDownLatch = countDownLatch;
            this.eventType = eventType;
        }

        @Override
        public void run() {
            couponService.enqueueCouponIssueRequest(eventType, UUID.randomUUID().toString());
            countDownLatch.countDown();
        }
    }
}