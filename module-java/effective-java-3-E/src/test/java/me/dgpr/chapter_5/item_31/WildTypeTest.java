package me.dgpr.chapter_5.item_31;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;

public class WildTypeTest {

    @Test
    void pushAllTest() {
        Stack<Number> stack = new Stack<>();
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);

        // Compile Error
        // stack.pushAll(intList);
    }

    @Test
    void test() {
        //Arrange
        // List<ScheduledFuture<Integer>> scheduledFutures = Arrays.asList();

        //Act
        // var max = max(scheduledFutures);

        //Assert
    }

    public static <E extends Comparable<? super E>> E max(List<? extends E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("빈 리스트: " + list);
        }

        E result = null;
        for (E e : list) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }
}
