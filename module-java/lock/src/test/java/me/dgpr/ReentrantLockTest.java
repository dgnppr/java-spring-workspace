package me.dgpr;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReentrantLockTest {

    @Test
    @DisplayName("생성자")
    void test1() throws Exception {
        new ReentrantLock();

        boolean fair = true; // true로 주면 가장 오래 기다린 쓰레드가  lock을 얻을 수 있도록 처리
        new ReentrantLock(fair); // 어떤 쓰레드가 가장 오래 기다렸는지 확인하는 과정이 필요하므로 성능이 떨어진다
    }

    @Test
    @DisplayName("API")
    void test2() throws Exception {
        ReentrantLock lock = new ReentrantLock();

        lock.lock(); // 락 잠금
        lock.unlock(); // 락 해제
        lock.isLocked(); // 락 잠금 확인
        lock.tryLock(); // long polling 방식
        lock.tryLock(1, TimeUnit.MINUTES); // 타임아웃 설정
    }

    @Test
    @DisplayName("Condition 으로 선별적 통지")
    void test3() throws Exception {
        ReentrantLock lock = new ReentrantLock();

        Condition task1 = lock.newCondition();
        Condition task2 = lock.newCondition();

        task1.await();
        task1.signal();
    }
}
