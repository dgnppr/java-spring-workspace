package me.dgpr;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InnerService {

    private final Logger logger = LoggerFactory.getLogger(InnerService.class);
    private final PersonRepository personRepository;

    public InnerService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void innerMethodThrowingRuntimeException() {
        personRepository.save(new PersonEntity("name"));
        throw new RuntimeException("innerMethodThrowingRuntimeException");
    }
}
