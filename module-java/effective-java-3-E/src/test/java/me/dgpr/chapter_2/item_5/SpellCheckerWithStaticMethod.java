package me.dgpr.chapter_2.item_5;

import java.util.HashMap;
import java.util.List;

public class SpellCheckerWithStaticMethod {
    private static final HashMap dict = new HashMap(); // 사전에 직접 의존

    private SpellCheckerWithStaticMethod() {
    }

    public static boolean isValid(String word) {
        return false; // dummy
    }

    public static List<String> suggestions(String type) {
        return null; // dummy
    }
}
