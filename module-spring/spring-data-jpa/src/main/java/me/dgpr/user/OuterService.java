package me.dgpr.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OuterService {

    private final InnerService innerService;
    private final OuterRepository outerRepository;

    public OuterService(
            InnerService innerService,
            OuterRepository outerRepository
    ) {
        this.innerService = innerService;
        this.outerRepository = outerRepository;
    }

    public UpdateResponse create(
            String outerName,
            String innerName
    ) {
        OuterEntity outer = outerRepository.save(
                new OuterEntity(outerName)
        );
        InnerEntity inner = innerService.create(innerName);

        return new UpdateResponse(
                outer.getId(),
                inner.getId()
        );
    }

    public UpdateResponse update(
            Long outerId,
            Long innerId,
            String outerName,
            String innerName
    ) {
        OuterEntity outer = outerRepository.findById(outerId)
                .orElseThrow(
                        () -> new RuntimeException("User not found with outerId: " + outerId));
        outer.updateName(outerName);
//        InnerEntity inner = innerService.update(innerId, innerName);

        return new UpdateResponse(
                outerId,
                innerId
        );
    }
}
