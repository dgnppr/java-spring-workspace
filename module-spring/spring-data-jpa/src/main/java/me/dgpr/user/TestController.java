package me.dgpr.user;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final OuterService outerService;

    public TestController(OuterService outerService) {
        this.outerService = outerService;
    }

    @PostMapping("/test")
    public UpdateResponse create(
            @RequestBody UpdateRequest request
    ) {
        UpdateResponse response = outerService.create(
                request.outerName(),
                request.innerName()
        );
        return response;
    }

    @PostMapping("/test/{outerId}/inners/{innerId}")
    public UpdateResponse update(
            @PathVariable("outerId") Long outerId,
            @PathVariable("innerId") Long innerId,
            @RequestBody UpdateRequest request
    ) {
        UpdateResponse response = outerService.update(
                outerId,
                innerId,
                request.outerName(),
                request.innerName()
        );

        return response;
    }
}
