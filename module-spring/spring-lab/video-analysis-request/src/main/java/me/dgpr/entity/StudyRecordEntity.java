package me.dgpr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "study_record")
public class StudyRecordEntity {

    @Id
    private Long idx;

    private String videoUrl;

    private Integer videoFrameCount;

    private Integer studyMin;

    public Long getIdx() {
        return idx;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Integer getVideoFrameCount() {
        return videoFrameCount;
    }

    public Integer getStudyMin() {
        return studyMin;
    }
}
