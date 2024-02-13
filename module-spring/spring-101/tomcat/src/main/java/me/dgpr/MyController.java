package me.dgpr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/blocked")
    public String getBlockedResponse() throws InterruptedException {
        Thread.sleep(1000); // 비즈니스 로직 처리에 thread가 1초 blocking 되는 환경 가정
        return "OK";
    }
}
