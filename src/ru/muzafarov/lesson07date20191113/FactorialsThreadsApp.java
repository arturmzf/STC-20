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

public class FactorialsThreadsApp {

    private static int[] intArray = new int[]{34, 563, 138, 1, 12, 8351, 0, 77, 365, 725};

    public static void main(String[] args) {

        Counter counter = new Counter();

        for (int i = 0; i < intArray.length; i++) {
            ResultThread thread = new ResultThread(counter);
            System.out.println(thread.toProcess(intArray[i]));
        }

    }

}