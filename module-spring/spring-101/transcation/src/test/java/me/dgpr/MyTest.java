package me.dgpr;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class MyTest {

    @Autowired
    private MyService myService;

    @Test
    void 안녕을_리턴한다() {
        assertThat(myService.returnHello()).isEqualTo("Hello");
    }
}
