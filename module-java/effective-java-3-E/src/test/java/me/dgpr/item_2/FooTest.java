package me.dgpr.item_2;

import static org.assertj.core.api.Assertions.assertThat;

import me.dgpr.item_2.Foo.Builder;
import org.junit.jupiter.api.Test;

class FooTest {

    @Test
    void 빌더_패턴_구현_테스트() {
        Foo foo = new Builder(1, 2)
                .optionalVar1(3)
                .optionalVar2(4)
                .build();

        assertThat(foo.getNecessaryVar1()).isOne();
        assertThat(foo.getNecessaryVar2()).isEqualTo(2);
        assertThat(foo.getOptionalVar1()).isEqualTo(3);
        assertThat(foo.getOptionalVar2()).isEqualTo(4);
    }

}