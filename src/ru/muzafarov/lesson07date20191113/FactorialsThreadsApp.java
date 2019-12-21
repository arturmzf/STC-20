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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialsThreadsApp {

    private static int[] numbers = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // Использовать Пул потоков и указать количество потоков (10 - 20) - лучше
        // Либо использовать Runnable()

        // Узнаём количество доступных ядер процессора
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество доступных ядер процессора: " + cores);

        ExecutorService service = Executors.newFixedThreadPool(cores);
        List<Future> futures = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            // System.out.println("BEGIN: " + i);
            Future future = service.submit(new FactorialThread(numbers[i]));
            futures.add(future);
            // System.out.println("END: " + i);
        }

        for(Future future : futures) {
            Integer[] results = (Integer[]) future.get();
            System.out.println("Number: " + results[0] + " - Result: " + results[1]);
        }

        // Как остановить?
    }

}
