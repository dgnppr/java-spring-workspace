package me.dgpr.service;


import java.util.List;
import me.dgpr.client.VideoAnalysisRequest;
import me.dgpr.entity.EventEntity;
import me.dgpr.entity.EventRepository;
import me.dgpr.entity.StudyRecordEntity;
import me.dgpr.entity.StudyRecordRepository;
import me.dgpr.exception.NotFoundVideoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideoAnalysisService {

    private final StudyRecordRepository studyRecordRepository;
    private final EventRepository eventRepository;

    public VideoAnalysisService(StudyRecordRepository studyRecordRepository,
                                EventRepository eventRepository) {
        this.studyRecordRepository = studyRecordRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void createAnalysisEvent(Long id) {
        // 1. 데이터 조회
        StudyRecordEntity recordEntity = studyRecordRepository.findById(id)
                .orElseThrow(() -> new NotFoundVideoException(id));

        // 2. 프레임 쪼개기
        List<VideoAnalysisRequest> requests = VideoAnalysisRequest.from(recordEntity);

        // 3. 이벤트 저장
        List<EventEntity> events = requests.stream()
                .map(VideoAnalysisRequest::toEvent)
                .toList();

        eventRepository.saveAll(events);
    }
}
