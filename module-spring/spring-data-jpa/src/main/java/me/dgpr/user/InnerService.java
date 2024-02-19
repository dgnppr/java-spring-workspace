package me.dgpr.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
@Transactional
public class InnerService {

    private final InnerRepository innerRepository;

    public InnerService(InnerRepository innerRepository) {
        this.innerRepository = innerRepository;
    }

    public InnerEntity create(String name) {
        InnerEntity entity = new InnerEntity(name);
        return innerRepository.save(entity);
    }

    public InnerEntity update(Long id, String name) {
        InnerEntity entity = innerRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("User not found with id: " + id));
        entity.updateName(name);
        return entity;
    }
}
