package me.dgpr.chapter_2.item_1;

import static org.assertj.core.api.Assertions.assertThat;

import me.dgpr.chapter_2.item_1.color.Color;
import me.dgpr.chapter_2.item_1.grade.GradeFactory;
import me.dgpr.chapter_2.item_1.flyweight.Flyweight;
import me.dgpr.chapter_2.item_1.flyweight.FlyweightFactory;
import me.dgpr.chapter_2.item_1.immutable.ImmutableClass;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyTest {

    @Test
    void 동치성_테스트() {
        Color color1 = Color.valueOf(255, 0, 0);
        Color color2 = Color.valueOf(255, 0, 0);

        assertThat(color1).isEqualTo(color2);
    }

    @Test
    void 분기_테스트() {
        Assertions.assertThat(GradeFactory.getGrade(90).getGrade()).isEqualTo("A");
        assertThat(GradeFactory.getGrade(89).getGrade()).isEqualTo("B");
    }

    @Test
    void 캐싱_테스트() {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweightA = factory.getFlyweight("A");
        Flyweight flyweightB = factory.getFlyweight("B");

        Flyweight flyweightA2 = factory.getFlyweight("A");

        assertThat(flyweightA).isEqualTo(flyweightA2);

        flyweightA.doOperation("Operation 1");
        flyweightB.doOperation("Operation 2");
        flyweightA2.doOperation("Operation 3");
    }

    @Test
    void 불변_테스트() {
        ImmutableClass obj = ImmutableClass.valueOf("Hello");

        assertThat(obj.getValue()).isEqualTo("Hello");
    }
}
