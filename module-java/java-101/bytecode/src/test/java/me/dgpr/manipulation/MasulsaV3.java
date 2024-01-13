package me.dgpr.manipulation;

import static net.bytebuddy.matcher.ElementMatchers.named;

import java.io.File;
import java.io.IOException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.pool.TypePool.Default;

public class MasulsaV3 {

    public static void main(String[] args) throws IOException {
        ClassLoader cl = MasulsaV3.class.getClassLoader();
        TypePool tp = Default.of(cl);

        ByteBuddy byteBuddy = new ByteBuddy();

        byteBuddy.redefine(
                        tp.describe("me.dgpr.manipulation.Moja").resolve(),
                        ClassFileLocator.ForClassLoader.of(cl)
                )
                .method(named("pullOut"))
                .intercept(FixedValue.value("Rabbit"))
                .make()
                .saveIn(new File("/Users/dragonappear/Programming/learning/java-101/bytecode/build/classes/java/test"));

        System.out.println(new Moja().pullOut());
    }
}
