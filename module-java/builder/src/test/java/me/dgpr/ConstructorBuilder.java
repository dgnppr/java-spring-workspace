package me.dgpr;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ConstructorBuilder {

    private String name;
    private int age;

    @Builder
    public ConstructorBuilder(String name) {
        this.name = name;
    }
}
