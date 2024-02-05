package me.dgpr.chapter_2.item_1.immutable;

public final class ImmutableClass {
    private final String value;

    private ImmutableClass(String value) {
        this.value = value;
    }

    public static ImmutableClass valueOf(String value) {
        return new ImmutableClass(value);
    }

    public String getValue() {
        return value;
    }
}
