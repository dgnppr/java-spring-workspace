package me.dgpr.chapter_2.item_5;

import java.util.HashMap;
import java.util.List;

public class SpellCheckerSingleton {

    private static final HashMap dict = new HashMap(); // 사전에 직접 의존
    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    private SpellCheckerSingleton() {
    }

    public boolean isValid(String word) {
        return false; // dummy
    }

    public List<String> suggestions(String type) {
        return null; // dummy
    }
}
