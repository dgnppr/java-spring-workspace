package me.dgpr;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    @GetMapping("/")
    public String my() {
        log.info("{}", Thread.currentThread().getName());
        return "hello";
    }
}
