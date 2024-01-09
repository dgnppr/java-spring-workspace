package me.dgpr.message;

import java.time.LocalDateTime;
import me.dgpr.client.VideoAnalysisClient;
import me.dgpr.client.VideoAnalysisRequest;
import me.dgpr.entity.EventRepository;
import me.dgpr.entity.EventStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessagePublisher {

    private static final Logger log = LoggerFactory.getLogger(MessagePublisher.class);
    private final VideoAnalysisClient videoAnalysisClient;
    private final EventRepository eventRepository;

    public MessagePublisher(
            VideoAnalysisClient videoAnalysisClient,
            EventRepository eventRepository
    ) {
        this.videoAnalysisClient = videoAnalysisClient;
        this.eventRepository = eventRepository;
    }

    @Scheduled(cron = "0/5 * * * * *")
    @Transactional
    public void publish() {
        LocalDateTime now = LocalDateTime.now();

        eventRepository.findByCreatedAtBefore(now, EventStatus.READY)
                .forEach(event -> {
                    try {
                        videoAnalysisClient.requestVideoAnalysis((VideoAnalysisRequest) event.getPayload());
                        event.done();
                        eventRepository.save(event);
                    } catch (Exception e) {
                        log.error("Error processing event: {}", event.getId(), e);
                    }
                });
    }
}
