package me.dgpr.chapter_3.item_14;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private int areaCode;
    private int prefix;
    private int lineNum;
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public PhoneNumber(
            int areaCode,
            int prefix,
            int lineNum
    ) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public int compareTo(PhoneNumber pn) {
        return COMPARATOR.compare(this, pn);
    }
}
