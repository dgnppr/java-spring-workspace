package me.dgpr;

import java.util.Objects;

@FunctionalInterface
public interface MyConsumer<T> {

    void accept(T t);

    default MyConsumer<T> andThen(MyConsumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> {
            accept(t);
            after.accept(t);
        };
    }
}
