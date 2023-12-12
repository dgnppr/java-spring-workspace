package me.dgpr.version_17;

public non-sealed class Cat extends Animal {

    private int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public void sound() {
        System.out.println("meow");
    }

    public int getAge() {
        return age;
    }
}
