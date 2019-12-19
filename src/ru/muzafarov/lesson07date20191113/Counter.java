/**
 * Занятие № 07 [от 13.11.2019 (Ср)]
 * Темы:
 * - Модель памяти Java
 * - Потоки выполнения
 * - Синхронизация
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson07date20191113;

public class Counter {

    private int counter;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void increment() {
        this.counter++;
    }

}
