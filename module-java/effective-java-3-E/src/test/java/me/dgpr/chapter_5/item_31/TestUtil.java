package me.dgpr.chapter_5.item_31;

import java.util.List;
import java.util.Objects;

public class TestUtil {

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
