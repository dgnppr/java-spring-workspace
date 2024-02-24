package me.dgpr.event.txeventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

//@Async
@Component
public class MyTxEventListenerAfterCommit {

    private static final Logger log = LoggerFactory.getLogger(MyTxEventListenerAfterCommit.class);

    @TransactionalEventListener
    public void handleMyEvent(MyEvent event) {
        log.info("MyTxEventListener AFTER_COMMIT Received event: {}", event);
        throw new RuntimeException("MyTxEventListener AFTER_COMMIT");
    }
}
