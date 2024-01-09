package me.dgpr.event;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.dgpr.client.VideoAnalysisClient;
import me.dgpr.client.VideoAnalysisRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Async
@Component
public class VideoAnalysisEventListener {

    private static final Logger log = LoggerFactory.getLogger(VideoAnalysisEventListener.class);
    private final Executor taskExecutor;
    private final VideoAnalysisClient videoAnalysisClient;

    public VideoAnalysisEventListener(
            @Qualifier("taskExecutor") Executor taskExecutor,
            VideoAnalysisClient videoAnalysisClient
    ) {
        this.taskExecutor = taskExecutor;
        this.videoAnalysisClient = videoAnalysisClient;
    }

    @EventListener
    @Transactional
    public void handleVideoAnalysisRequest(VideoAnalysisEvent videoAnalysisEvent) {
        List<VideoAnalysisRequest> requests = videoAnalysisEvent.requests();

        // 모든 요청을 병렬로 처리
        CompletableFuture<?>[] responses = requests.stream()
                .map(request -> CompletableFuture.runAsync(
                        () -> videoAnalysisClient.requestVideoAnalysis(request), taskExecutor)
                )
                .toArray(CompletableFuture[]::new);

        // 모든 요청이 완료될 때까지 대기
        CompletableFuture.allOf(responses)
                .exceptionally(throwable -> {
                    log.error("Error in processing video analysis requests", throwable);
                    return null;
                })
                .join();

    }
}
