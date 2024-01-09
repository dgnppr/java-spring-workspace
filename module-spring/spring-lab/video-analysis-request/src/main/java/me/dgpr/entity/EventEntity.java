package me.dgpr.entity;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "video_analysis_event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime createdAt;

    private EventStatus status;

    @Type(JsonType.class)
    private Object payload; // 페이로드에 맞는 클래스 생성해줘야함

    public EventEntity() {

    }

    public EventEntity(
            LocalDateTime createdAt,
            Object payload
    ) {
        this.createdAt = createdAt;
        this.status = EventStatus.READY;
        this.payload = payload;
    }

    public Long getId() {
        return id;
    }

    public Object getPayload() {
        return payload;
    }

    public void done() {
        this.status = EventStatus.DONE;
    }
}
