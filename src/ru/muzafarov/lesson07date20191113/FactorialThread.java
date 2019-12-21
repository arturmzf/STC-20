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

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialThread implements Callable {

    private int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public Integer[] call() throws Exception {
        System.out.println("Number: " + number);
        int result = 1;
        try {
            for(int i = number; i > 0; i--) {
                TimeUnit.SECONDS.sleep(1);
                result *= i;
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // System.out.println(result);
        return new Integer[]{number, result};
    }
}
