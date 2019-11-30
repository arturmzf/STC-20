/**
 * Занятие № 3 [от 01.11.2019 (Пт)]
 * Темы:
 * - Исключения.
 * - Родовые типы Java (Generics)
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson03date20191101.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ObjectBox {

    private Object[] objects;

    private List<Number> objectsCollection;

    public ObjectBox(Object[] objects) {

        this.objects = objects;

        this.objectsCollection = new ArrayList<Number>(Arrays.asList(objects));

    }

    public void addObject() {



    }

    public void deleteObject() {



    }

    public void dump() {



    }

}
