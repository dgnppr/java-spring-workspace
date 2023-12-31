package me.dgpr.item_2;

import static me.dgpr.item_2.NyPizza.Size.LARGE;
import static me.dgpr.item_2.Pizza.Topping.ONION;
import static me.dgpr.item_2.Pizza.Topping.SAUSAGE;
import static org.assertj.core.api.Assertions.assertThat;

import me.dgpr.item_2.NyPizza.Builder;
import org.junit.jupiter.api.Test;

class NyPizzaTest {

    @Test
    void 계층적_빌더_패턴_구현_테스트() {
        Pizza pizza = new Builder(LARGE)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();

        assertThat(pizza.getToppings()).containsOnly(SAUSAGE, ONION);
    }
}