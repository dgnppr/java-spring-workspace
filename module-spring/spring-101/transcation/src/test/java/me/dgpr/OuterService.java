package me.dgpr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OuterService {

    private final Logger logger = LoggerFactory.getLogger(OuterService.class);
    private final InnerService innerService;

    public OuterService(InnerService innerService) {
        this.innerService = innerService;
    }

    public void outerMethod() {
        try {
            innerService.innerMethodThrowingRuntimeException();
        } catch (RuntimeException exception) {
            logger.warn("OuterService caught exception: {}", exception.getMessage());
        }
    }
}
