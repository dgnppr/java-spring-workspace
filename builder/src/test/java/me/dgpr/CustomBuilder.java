package me.dgpr;

public class CustomBuilder {

    private String name;
    private int age;

    public CustomBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Builder build() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

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

        public CustomBuilder build() {
            return new CustomBuilder(this);
        }
    }
}

