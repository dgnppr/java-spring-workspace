package me.dgpr.client;

public record VideoAnalysisRequest(Long idx,
                                   String callbackURL,
                                   String videoURL,
                                   Integer analysisStartFrame,
                                   Integer analysisLastFrame) {
}
