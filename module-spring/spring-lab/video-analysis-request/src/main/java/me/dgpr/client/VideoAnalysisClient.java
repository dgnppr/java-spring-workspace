package me.dgpr.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "video-analysis-client",
        url = "http://localhost:8081" // AI LoadBalancerServer or Queue Server
)
public interface VideoAnalysisClient {

    @PostMapping
    @Retryable(
            maxAttempts = 5,
            backoff = @Backoff(delay = 10000)
    )
    VideoAnalysisResponse requestVideoAnalysis(@RequestBody VideoAnalysisRequest request);
}
