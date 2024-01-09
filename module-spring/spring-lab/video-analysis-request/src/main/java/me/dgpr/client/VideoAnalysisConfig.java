package me.dgpr.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VideoAnalysisConfig {
    @Bean
    public VideoAnalysisDecoder videoAnalysisDecoder() {
        return new VideoAnalysisDecoder();
    }
}
