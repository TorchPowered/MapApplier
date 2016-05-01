package org.example;

import java.lang.reflect.Field;

/**
 * The main target of the obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
public class Main {
    private String thisIsAField = "Test";

    public static void main(String[] args) {
        new Main().printMessage();
    }

    public void printMessage() {
        for (Field field : this.getClass().getDeclaredFields()) {
            System.out.println(field.getName());
        }
    }
}
