package me.dgpr;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MyTest {

    /**
     * 컨슈머는 싱글 입력값을 accept 하여 반환값 없이 어떠한 액션을 수행한다.
     */
    @Test
    void consumer_테스트() {
        MyConsumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        MyConsumer<String> printLowerCase = str -> System.out.println(str.toLowerCase());
        MyConsumer<String> printBoth = printUpperCase.andThen(printLowerCase);

        printBoth.accept("WORLD");
    }

    /**
     * 입력값을 받아서 조건식에 따라 boolean 값으로 리턴한다
     */
    @Test
    void predicate_테스트() {
        MyPredicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Output: true
        System.out.println(isEven.test(7)); // Output: false

        MyPredicate<Integer> isGreaterThanTen = num -> num > 10;
        MyPredicate<Integer> isEvenAndGreaterThanTen = isEven.and(isGreaterThanTen);
        System.out.println(isEvenAndGreaterThanTen.test(12)); // Output: true

        MyPredicate<Integer> isOddOrLessThanFive = isEven.negate().or(num -> num < 5);
        System.out.println(isOddOrLessThanFive.test(3)); // Output: true
    }

    /**
     * 어떠한 입력값없이 특정 타입의 값을 반환한다
     */
    @Test
    void supplier_테스트() {
        MySupplier<Double> randomNumberSupplier = Math::random;
        System.out.println(randomNumberSupplier.get());

        MySupplier<String> greetingsSupplier = () -> {
            String[] greetings = {"Hello", "Bonjour", "Hola", "Namaste"};
            int randomIndex = (((int) (Math.random() * 10)) % greetings.length);
            return greetings[randomIndex];
        };
        System.out.println(greetingsSupplier.get());
    }
}
