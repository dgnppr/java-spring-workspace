package me.dgpr.chapter_3.item_13;

public class PhoneNumber {

    private int areaCode;
    private int prefix;
    private int lineNum;

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
    public String toString() {
        return String.format(
                "%03d-%03d-%04d",
                areaCode,
                prefix,
                lineNum
        );
    }

    @Override
    protected Object clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}
