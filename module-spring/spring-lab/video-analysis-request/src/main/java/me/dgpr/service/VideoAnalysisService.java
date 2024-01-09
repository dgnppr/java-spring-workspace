package me.dgpr.service;


import java.util.List;
import me.dgpr.client.VideoAnalysisRequest;
import me.dgpr.entity.StudyRecordEntity;
import me.dgpr.entity.StudyRecordRepository;
import me.dgpr.event.VideoAnalysisEvent;
import me.dgpr.exception.NotFoundVideoException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class VideoAnalysisService {

    private final StudyRecordRepository studyRecordRepository;
    private final ApplicationEventPublisher eventPublisher;

    public VideoAnalysisService(StudyRecordRepository studyRecordRepository,
                                ApplicationEventPublisher eventPublisher) {
        this.studyRecordRepository = studyRecordRepository;
        this.eventPublisher = eventPublisher;
    }

    public void sendAnalysisRequest(Long id) {
        // 1. 데이터 조회
        StudyRecordEntity record = studyRecordRepository.findById(id)
                .orElseThrow(() -> new NotFoundVideoException(id));

        // 2. 프레임 쪼개기
        List<VideoAnalysisRequest> requests = VideoAnalysisRequest.from(record);

        // 3. 이벤트 발행
        eventPublisher.publishEvent(new VideoAnalysisEvent(requests));
    }
}
