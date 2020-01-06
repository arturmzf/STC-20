/**
 * Занятие № 09 [от 18.11.2019 (Пн)]
 * Темы:
 * - CllassLoaders
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson09date20191118;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        if ("SomeClass".equals(name)) {
            try {
                byte[] classInBytesView = Files.readAllBytes(Paths.get("./someClass.class"));
                return defineClass(name, classInBytesView, 0, classInBytesView.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.findClass(name);
    }
}
