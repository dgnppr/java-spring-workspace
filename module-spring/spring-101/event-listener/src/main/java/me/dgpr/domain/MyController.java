package me.dgpr.domain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService myService;

    public MyController(
            final MyService myService
    ) {
        this.myService = myService;
    }


    @PostMapping("/my")
    public Long createMyEntity() {
        return myService.createMyEntity();
    }
}
