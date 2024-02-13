package me.dgpr;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class VirtualThreadTest {

    @Test
    void 가상_쓰레드_생성하고_실행하기() {

        // 실행 방법 - 1
        Thread.startVirtualThread(() -> {
            System.out.println("Hello, Virtual Thread!");
        });

        // 실행 방법 - 2
        Runnable runnable = () -> System.out.println("Hello, Virtual Thread!");
        Thread vt1 = Thread.ofVirtual().start(runnable);

        // 이름 지정
        Thread.Builder builder = Thread.ofVirtual().name("My Virtual Thread");
        Thread vt2 = builder.start(runnable);

        // 가상 쓰레드인지 확인
        System.out.println("Is this virtual thread? " + vt2.isVirtual());

        // ExectuorService를 사용
        try (final ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                executor.submit(runnable);
            }
        }
    }
}
