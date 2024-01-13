package me.dgpr.version_17;

import java.io.Serializable;
import java.util.UUID;

public record Person(int id, String name) implements Serializable {

    // Compact Constructor
    public Person {
        if (id < 0) {
            throw new IllegalArgumentException();
        }
    }

    // Alternative Constructor
    public Person(int id) {
        this(id, null);
    }

    // Instance methods
    public String getIdAndName() {
        return id + " " + name;
    }

    // Static methods
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }

    // Nested classes
    public class NestedClass {
        private int anInt;
    }
}
