package me.dgpr.domain;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyService {

    private static final Logger log = LoggerFactory.getLogger(MyService.class);
    private final MyRepository myRepository;
    private final ApplicationEventPublisher publisher;

    public MyService(
            final MyRepository myRepository,
            final ApplicationEventPublisher publisher
    ) {
        this.myRepository = myRepository;
        this.publisher = publisher;
    }

    public Long createMyEntity() {
        log.info("Creating a new MyEntity");
        var myId = myRepository.save(new MyEntity()).getId();
        publisher.publishEvent(new MyEvent(myId));
        log.info("MyEntity created with id: {}", myId);
        return myId;
    }
}
