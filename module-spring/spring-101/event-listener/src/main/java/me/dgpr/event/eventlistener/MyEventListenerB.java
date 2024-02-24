package me.dgpr.event.eventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyEventListenerB {

    private static final Logger log = LoggerFactory.getLogger(MyEventListenerB.class);

    //@EventListener
    public void handleMyEvent(MyEvent event) {
        // log.info("MyEventListener B Received event: {}", event);
    }
}
