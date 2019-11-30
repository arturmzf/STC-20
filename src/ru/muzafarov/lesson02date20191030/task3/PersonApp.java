/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

import java.util.Random;

public class PersonApp {

    public static void main(String[] args) {

        // Автоматическая генерация массива
        int arraySize = 1000;
        Person[] personAutomatic = new Person[arraySize];
        Sex sex;

        for(int i = 0; i < arraySize; i++) {

            Random rnd = new Random();
            sex = (rnd.nextInt(2) == 0) ? Sex.WOMAN : Sex.MAN;
            String stUppercase = "АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ";
            String stLowercase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
            String name = "";

            name += stUppercase.charAt(rnd.nextInt(stUppercase.length()));

            for(int d = 0; d < rnd.nextInt(20); d++) {

                name += stLowercase.charAt(rnd.nextInt(stLowercase.length()));

            };

            name += " ";
            name += stUppercase.charAt(rnd.nextInt(stUppercase.length()));

            for(int d = 0; d < rnd.nextInt(20); d++) {

                name += stLowercase.charAt(rnd.nextInt(stLowercase.length()));

            };

            name += " ";
            name += stUppercase.charAt(rnd.nextInt(stUppercase.length()));

            for(int d = 0; d < rnd.nextInt(20); d++) {

                name += stLowercase.charAt(rnd.nextInt(stLowercase.length()));

            };

            personAutomatic[i] = new Person(
                    name,
                    (byte) rnd.nextInt(100),
                    sex
            );

        }

        // Ручное заполнение массива
        Person[] persons1 = new Person[]{
                new Person(
                "Музафаров Артур Ринатович",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "Музафаров Артур Ринатович",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                   "Сидоров Андрей Николаевич",
                        (byte) 33,
                        Sex.MAN
                ),
                new Person(
                        "Жуковская Светлана Евгеньевна",
                        (byte) 16,
                        Sex.WOMAN
                ),
                new Person(
                        "Киселёв Дмитрий Романович",
                        (byte) 52,
                        Sex.MAN
                ),
                new Person(
                        "Старостина Арина Леонидовна",
                        (byte) 23,
                        Sex.WOMAN
                ),
                new Person(
                        "Кондратьева Алевтина Петровна",
                        (byte) 73,
                        Sex.WOMAN
                ),
                new Person(
                        "Лукьянов Константин Сергеевич",
                        (byte) 64,
                        Sex.MAN
                ),
                new Person(
                        "Леонтьева Светлана Юрьевна",
                        (byte) 46,
                        Sex.WOMAN
                ),
                //
                new Person(
                        "Мустафина Алия Артуровна",
                        (byte) 19,
                        Sex.WOMAN
                ),
                new Person(
                        "Вышинская Кристина Валерьевна",
                        (byte) 37,
                        Sex.WOMAN
                ),
                new Person(
                        "Зиятдинов Мансур Тагирович",
                        (byte) 26,
                        Sex.MAN
                ),
                new Person(
                        "Хуснуллин Марат Радикович",
                        (byte) 40,
                        Sex.MAN
                ),
                new Person(
                        "Мартынова Анна Сергеевна",
                        (byte) 49,
                        Sex.WOMAN
                ),
                new Person(
                        "Димухаметова Танзиля Фархатовна",
                        (byte) 29,
                        Sex.WOMAN
                ),
                new Person(
                        "Короткова Лариса Михайловна",
                        (byte) 67,
                        Sex.WOMAN
                ),
                new Person(
                        "Пучков Владимир Анатольевич",
                        (byte) 37,
                        Sex.MAN
                )
        };

        // Для проверки
        Person[] persons2 = new Person[]{
                new Person(
                        "ААА",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ДДД",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 50,
                        Sex.MAN
                ),
                new Person(
                        "ДДД",
                        (byte) 50,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 15,
                        Sex.MAN
                ),
                new Person(
                        "ДДД",
                        (byte) 15,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 38,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 38,
                        Sex.WOMAN
                ),
                new Person(
                        "ААА",
                        (byte) 38,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 38,
                        Sex.WOMAN
                ),
                new Person(
                        "ЕЕЕ",
                        (byte) 38,
                        Sex.WOMAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 38,
                        Sex.MAN
                ),
                new Person(
                        "ДДД",
                        (byte) 38,
                        Sex.WOMAN
                )
        };

        // Для отладки
        Person[] persons3 = new Person[]{
                new Person(
                        "ААА",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ААА",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "БББ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ВВВ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "БББ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "AAA",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 27,
                        Sex.MAN
                ),
                new Person(
                        "ГГГ",
                        (byte) 27,
                        Sex.WOMAN
                ),
                new Person(
                        "ДДД",
                        (byte) 27,
                        Sex.MAN
                )
        };

        BubbleSorting bs = new BubbleSorting(persons1);
        bs.arrayPrinting("Первоначальный массив:");
        bs.sort();
        bs.arrayPrinting("Массив после сортировки:");

        /*
        InsertionSorting is = new InsertionSorting(personAutomatic);
        is.arrayPrinting("Первоначальный массив:");
        is.sort();
        is.arrayPrinting("Массив после сортировки:");
        */

    }

}
