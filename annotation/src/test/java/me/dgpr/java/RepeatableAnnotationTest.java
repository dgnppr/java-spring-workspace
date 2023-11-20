package me.dgpr.java;

import java.lang.annotation.Repeatable;

public class RepeatableAnnotationTest {
}

@Repeatable(Todos.class)
@interface Todo {
    String value();
}

@interface Todos {
    Todo[] value();
}

@Todo("delete test codes")
@Todo("refactoring production codes")
class TodoClass {
}
