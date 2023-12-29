package me.dgpr.tx;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TxController {

    private final TxService txService;

    @GetMapping("/")
    public ResponseEntity test() {
        txService.test();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
