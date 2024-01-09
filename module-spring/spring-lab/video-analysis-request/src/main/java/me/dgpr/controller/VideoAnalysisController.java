package me.dgpr.controller;

import me.dgpr.service.VideoAnalysisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoAnalysisController {

    private final VideoAnalysisService videoAnalysisService;

    public VideoAnalysisController(VideoAnalysisService videoAnalysisService) {
        this.videoAnalysisService = videoAnalysisService;
    }

    @GetMapping("/api/v1/analysis/{id}")
    public ResponseEntity<Void> analysis(@PathVariable Long id) {
        videoAnalysisService.sendAnalysisRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
