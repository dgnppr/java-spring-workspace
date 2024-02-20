package me.dgpr.chapter_3.item_14;

public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
    }
}
