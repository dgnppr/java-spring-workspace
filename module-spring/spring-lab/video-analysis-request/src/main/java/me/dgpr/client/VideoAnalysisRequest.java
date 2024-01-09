package me.dgpr.client;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import me.dgpr.entity.EventEntity;
import me.dgpr.entity.StudyRecordEntity;

public record VideoAnalysisRequest(Long idx,
                                   String callbackURL,
                                   String videoURL,
                                   Integer analysisStartFrame,
                                   Integer analysisLastFrame) {

    public static List<VideoAnalysisRequest> from(StudyRecordEntity entity) {
        // 페이지 처리
        return new ArrayList<>();
    }

    public EventEntity toEvent() {
        return new EventEntity(LocalDateTime.now(), this);
    }
}
