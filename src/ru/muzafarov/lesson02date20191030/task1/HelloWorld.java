/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class HelloWorld {

    static int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8 ,9};

    public static void main(String[] args) {

        try {

            /*List<Integer> list = null;
            System.out.println(list.get(0));*/

            //throw new NullPointerException();
            //System.out.println(array[10]);

            throw new MyException();
            //FileReader fr = new FileReader("file.file");

        } catch(NullPointerException e) {

            System.out.println("Внимание! Ошибка работы с объектом!");

        } catch(ArrayIndexOutOfBoundsException e) {

            System.out.println("Внимание! Ошибка работы с массивом!");

        } /*catch(FileNotFoundException e) {

            System.out.println("Внимание! Ошибка работы с файлом!");

        }*/ catch (MyException e) {

            System.out.println("Внимание! Пользовательская ошибка!");

        } finally {

            System.out.println("Hello, World!");

        }

    }

}
