package me.dgpr.chapter_2.item_2;

public class Foo {

    private final int necessaryVar1;
    private final int necessaryVar2;
    private final int optionalVar1;
    private final int optionalVar2;

    public static class Builder {
        // 필수 매개변수
        private final int necessaryVar1;
        private final int necessaryVar2;

        // 선택 매개변수 - 기본값으로 초기화
        private int optionalVar1 = 0;
        private int optionalVar2 = 0;

        public Builder(int necessaryVar1, int necessaryVar2) {
            this.necessaryVar1 = necessaryVar1;
            this.necessaryVar2 = necessaryVar2;
        }

        public Builder optionalVar1(int val) {
            this.optionalVar1 = val;
            return this;
        }

        public Builder optionalVar2(int val) {
            this.optionalVar2 = val;
            return this;
        }

        public Foo build() {
            return new Foo(this);
        }
    }

    public Foo(Builder builder) {
        this.necessaryVar1 = builder.necessaryVar1;
        this.necessaryVar2 = builder.necessaryVar2;
        this.optionalVar1 = builder.optionalVar1;
        this.optionalVar2 = builder.optionalVar2;
    }

    public int getNecessaryVar1() {
        return necessaryVar1;
    }

    public int getNecessaryVar2() {
        return necessaryVar2;
    }

    public int getOptionalVar1() {
        return optionalVar1;
    }

    public int getOptionalVar2() {
        return optionalVar2;
    }
}
