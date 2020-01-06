/**
 * Занятие № 09 [от 18.11.2019 (Пн)]
 * Темы:
 * - CllassLoaders
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson09date20191118;

public class SomeClass implements Worker {
    private int someClassInt = 7;
    private String someClassString = "Seven";

    @Override
    public void doWork() {
        System.out.println(someClassInt + " is " + someClassString);
    }

    /*
    @Override
    public void someClassDoesSomething() implements Worker {
        System.out.println(someClassInt + " is " + someClassString);
    }
    */
}
