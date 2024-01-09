package me.dgpr.event;

import java.util.List;
import me.dgpr.client.VideoAnalysisRequest;

public record VideoAnalysisEvent(List<VideoAnalysisRequest> requests) {
}
