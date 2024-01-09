package me.dgpr.entity;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {
    List<EventEntity> findByCreatedAtBefore(LocalDateTime now, EventStatus eventStatus);
}
