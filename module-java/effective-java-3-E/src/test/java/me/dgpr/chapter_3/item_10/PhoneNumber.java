package me.dgpr.chapter_3.item_10;

public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        rangeCheck(areaCode, 999, "area code");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNum, 9999, "line num");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNum = (short) lineNum;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
    }
}
