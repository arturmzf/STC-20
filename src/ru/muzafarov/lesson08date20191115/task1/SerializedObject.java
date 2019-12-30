/**
 * Занятие № 08 [от 15.11.2019 (Пт)]
 * Темы:
 * - Механизмы отражения
 * - Механизмы проксирования
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson08date20191115.task1;

import java.io.Serializable;

public class SerializedObject implements Serializable {

    private int a;
    private float b;
    private boolean c;
    private String d;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public void toDo() {
        System.out.println("To Do!");
    }

}
