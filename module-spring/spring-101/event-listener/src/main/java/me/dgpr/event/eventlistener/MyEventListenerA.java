package me.dgpr.event.eventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventListenerA {

    private static final Logger log = LoggerFactory.getLogger(MyEventListenerA.class);

    @Async
    //@EventListener
    public void handleMyEvent(MyEvent event) {
        // log.info("MyEventListener A Received event: {}", event);
    }
}
