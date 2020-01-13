/**
 * Занятие № 09 [от 18.11.2019 (Пн)]
 * Темы:
 * - CllassLoaders
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson09date20191118;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ClassLoaderApp {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
        Worker someClass = new SomeClass();
        someClass.doWork();
        */
        ClassLoader classLoader = new MyClassLoader();

        Class<?> cls = Class.forName("SomeClass", true, classLoader);
        Object instance = cls.getDeclaredConstructor().newInstance();
        instance.getClass().getDeclaredMethod("doWork").invoke(instance);

        /*
        ls.getMethod("doWork").invoke(cls.getDeclaredConstructor().newInstance());
        */


        /*
        Scanner scanner = new Scanner(System.in);
        int aaa = scanner.nextInt();
        while(aaa != -1) {

        }
        */
    }
    
}
