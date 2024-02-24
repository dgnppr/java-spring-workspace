package me.dgpr.event.txeventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyTxEventListenerBeforeCommit {

    private static final Logger log = LoggerFactory.getLogger(MyTxEventListenerBeforeCommit.class);

    //@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleMyEvent(MyEvent event) {
        log.info("MyTxEventListener BEFORE_COMMIT Received event: {}", event);
    }
}
