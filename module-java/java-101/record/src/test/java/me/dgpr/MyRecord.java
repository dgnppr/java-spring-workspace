package me.dgpr;

public record MyRecord(String name, int age) {

    public static class Builder {
        private String name;
        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public MyRecord build() {
            return new MyRecord(name, age);
        }
    }
}
