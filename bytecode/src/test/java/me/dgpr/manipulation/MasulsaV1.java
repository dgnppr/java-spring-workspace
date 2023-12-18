package me.dgpr.manipulation;

import java.io.IOException;

public class MasulsaV1 {

    public static void main(String[] args) throws IOException {
//        ByteBuddy byteBuddy = new ByteBuddy();
//
//        byteBuddy.redefine(Moja.class)
//                .method(named("pullOut"))
//                .intercept(FixedValue.value("Rabbit"))
//                .make()
//                .saveIn(new File("/Users/dragonappear/Programming/learning/java-101/bytecode/build/classes/java/test"));

        System.out.println(new Moja().pullOut());
    }
}
