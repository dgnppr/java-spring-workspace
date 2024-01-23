package me.dgpr;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InnerService {

    private final PersonRepository personRepository;

    public InnerService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void innerMethodThrowingRuntimeException() {
        personRepository.save(new PersonEntity("name"));
        throw new RuntimeException("innerMethodThrowingRuntimeException");
    }
}
