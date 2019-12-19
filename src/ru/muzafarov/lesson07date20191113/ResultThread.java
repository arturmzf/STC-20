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

public class ResultThread extends Thread {

    private final Counter counter;

    public ResultThread(Counter counter) {
        this.counter = counter;
    }

    public int toProcess(int arg) {
        int result = 1;
        for (int i = arg; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

}
