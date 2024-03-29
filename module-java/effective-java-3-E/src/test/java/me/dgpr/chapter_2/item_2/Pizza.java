package me.dgpr.chapter_2.item_2;


import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPEER, SAUSAGE}

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 오버라이딩하여 "this"를 반환하도록 해야 한다
        protected abstract T self();
    }

    public Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public Set<Topping> getToppings() {
        return toppings;
    }
}
