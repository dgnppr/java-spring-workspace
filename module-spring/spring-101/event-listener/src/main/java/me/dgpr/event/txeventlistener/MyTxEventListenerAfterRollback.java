package me.dgpr.event.txeventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyTxEventListenerAfterRollback {

    private static final Logger log = LoggerFactory.getLogger(MyTxEventListenerAfterRollback.class);

    //@TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleMyEvent(MyEvent event) {
        log.info("MyTxEventListener AFTER_ROLLBACK Received event: {}", event);
    }
}
