package me.dgpr;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AtomicTest {

    static final int MAX = 100_000;

    @Test
    @DisplayName("AtomicBoolean")
    void test1() throws Exception {
        AtomicBoolean flag = new AtomicBoolean(false);

        while (!flag.compareAndSet(false, true)) {
            // 임계 영역
        }
    }

    @Test
    @DisplayName("AtomicInteger")
    void test2() throws Exception {
        AtomicInteger count = new AtomicInteger();

        Thread[] threads = createThreads();

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < MAX; j++) {
                    count.incrementAndGet();
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("atomicInteger.get(): " + count.get());
    }

    private Thread[] createThreads() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread();
        }
        return threads;
    }
}
