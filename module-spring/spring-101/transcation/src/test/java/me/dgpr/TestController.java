package me.dgpr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final OuterService outerService;

    public TestController(OuterService outerService) {
        this.outerService = outerService;
    }

    @GetMapping("/test")
    public void test() {
        outerService.outerMethod();
    }
}
