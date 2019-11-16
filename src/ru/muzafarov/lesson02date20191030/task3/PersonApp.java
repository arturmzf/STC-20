/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

public class PersonApp {

    public static void main(String[] args) {

        /*
        // Автоматическая генерация массива
        String st = "ABCDEF";

        for(int i = 0; i < 10; i++) {

            String name = "";

            for(int j = 0; j < 4; j++) {

                Random rnd = new Random();

                name += st.charAt(rnd.nextInt(st.length()));

            }

            System.out.println(name);
        }
        */

        // Ручное заполнение массива
        Person[] persons = new Person[]{
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
                        "Пучков Владимир Анатольевич",
                        (byte) 37,
                        Sex.MAN
                ),
                new Person(
                        "Короткова Лариса Михайловна",
                        (byte) 67,
                        Sex.WOMAN
                )
        };

        BubbleSorting bs = new BubbleSorting(persons);
        bs.arrayPrinting("Первоначальный массив:");
        bs.sort();
        bs.arrayPrinting("Массив после сортировки:");

    }

}
