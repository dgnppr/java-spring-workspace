package me.dgpr;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClassBuilder {
    private String name;
    private int age;
}
