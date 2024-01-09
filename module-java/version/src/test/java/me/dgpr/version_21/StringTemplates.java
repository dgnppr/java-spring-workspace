package me.dgpr.version_21;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringTemplates {

    @Test
    void string_템플릿() {
        String name = "Alice";
        int age = 30;
        //String message = STR."Hello, \{name}. You are \{age} years old.";

        // System.out.println(message);
    }
}
