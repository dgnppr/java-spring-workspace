package me.dgpr.event.txeventlistener;

import me.dgpr.event.MyEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyTxEventListenerAfterCompletion {

    private static final Logger log = LoggerFactory.getLogger(
            MyTxEventListenerAfterCompletion.class);

    //@TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    public void handleMyEvent(MyEvent event) {
        log.info("MyTxEventListener AFTER_COMPLETION Received event: {}", event);
    }
}
