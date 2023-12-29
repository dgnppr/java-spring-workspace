package me.dgpr;

import java.util.TreeSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetTest {

    @Test
    @DisplayName("TreeSet headSet, tailSet")
    void test1() throws Exception {
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        System.out.println(set.headSet(3));
        System.out.println(set.tailSet(3));
    }
}
