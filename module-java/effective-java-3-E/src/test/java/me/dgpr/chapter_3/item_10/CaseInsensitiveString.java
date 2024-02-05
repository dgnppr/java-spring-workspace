package me.dgpr.chapter_3.item_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CaseInsensitiveString
                && ((CaseInsensitiveString) obj).s.equalsIgnoreCase(s);
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Hello");
        String s = "hello";

        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false

        List<CaseInsensitiveString> cises = new ArrayList<>();
        cises.add(cis);
        System.out.println(cises.contains(s)); // false
    }
}
