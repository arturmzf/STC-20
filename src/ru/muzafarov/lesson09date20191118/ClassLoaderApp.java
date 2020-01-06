/**
 * Занятие № 09 [от 18.11.2019 (Пн)]
 * Темы:
 * - CllassLoaders
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson09date20191118;

import java.util.Scanner;

public class ClassLoaderApp {
    public static void main(String[] args) {
        Worker someClass = new SomeClass();
        someClass.doWork();
        /*
        Scanner scanner = new Scanner(System.in);
        int aaa = scanner.nextInt();
        while(aaa != -1) {

        }
        */
    }

    private static void usingMyClassLoader() throws Exception {
        ClassLoader classLoader = new MyClassLoader();
        Class<?> someClass = classLoader.loadClass("SomeClass");
    }
}
