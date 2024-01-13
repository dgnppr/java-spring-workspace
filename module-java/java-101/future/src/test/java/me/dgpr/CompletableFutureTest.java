package me.dgpr;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompletableFutureTest {

    private static final Logger log = LoggerFactory.getLogger(CompletableFutureTest.class);

    /**
     * runAsync
     * <p>
     * - 반환값 없음 - 비동기로 작업 실행 콜
     */
    @Test
    void runAsync_테스트() throws ExecutionException, InterruptedException {
        //Arrange
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });

        //Act
        future.get();
        System.out.println("Thread: " + Thread.currentThread().getName());
    }

    /**
     * supplyAsync
     * <p>
     * - 반환값이 있음 - 비동기 작업 실행 콜
     */
    @Test
    void supplyAsync_테스트() throws ExecutionException, InterruptedException {
        //Arrange
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Thread: " + Thread.currentThread().getName();
        });

        //Act
        System.out.println(future.get());
        System.out.println("Thread: " + Thread.currentThread().getName());
    }


    @Test
    void allOf_테스트() throws ExecutionException, InterruptedException {
        //Arrange
        CompletableFuture<Void> hello = CompletableFuture.runAsync(() -> {
            System.out.println("hello");
        });

        CompletableFuture<Void> name = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            throw new IllegalStateException();
        });

        CompletableFuture[] futures = List.of(hello, name).toArray(new CompletableFuture[2]);

        CompletableFuture.allOf(futures)
                .exceptionally(ex -> {
                            log.error("Error in processing video analysis requests", ex);
                            return null;
                        }
                )
                .join();

    }

}
