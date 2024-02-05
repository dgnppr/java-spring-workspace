package me.dgpr.chapter_2.item_1.flyweight;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FlyweightPatternTest {

    @Test
    void test() {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweightA = factory.getFlyweight("A");
        Flyweight flyweightB = factory.getFlyweight("B");

        Flyweight flyweightA2 = factory.getFlyweight("A");

        assertThat(flyweightA).isEqualTo(flyweightA2);

        flyweightA.doOperation("Operation 1");
        flyweightB.doOperation("Operation 2");
        flyweightA2.doOperation("Operation 3");
    }
}
