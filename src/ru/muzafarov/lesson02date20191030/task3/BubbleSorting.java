/**
 * Занятие № 02 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

import java.util.Comparator;

public class BubbleSorting implements Sorting, Comparator<String> {

    private Person[] persons;
    private int counter = 0;

    public BubbleSorting(Person[] persons){

        this.persons = persons;

    }

    @Override
    public int compare(String title1, String title2) {

        return title1.compareTo(title2);

    }

    public void arrayPrinting(String message) {

        System.out.println("==============================");
        System.out.println("Работа пузырьковой сортировки");
        System.out.println("==============================");
        System.out.println(message);
        System.out.println();

        for(int m = 0; m < this.persons.length; m++) {

            System.out.println("Пол: " + this.persons[m].getSex().getSexRuChar() +
                    " - Возраст: " + this.persons[m].getAge() +
                    " - Ф.И.О.: " + this.persons[m].getName());

        }

        System.out.println("==============================");
        System.out.println("Время работы массива: " + this.counter);
        System.out.println("==============================");
        System.out.println();

    }

    public Person[] swap(Person[] personsTemp, int first, int second) {

        Person person1 = personsTemp[first].clone();
        Person person2 = personsTemp[second].clone();
        personsTemp[first] = person2;
        personsTemp[second] = person1;

        return personsTemp;

    }

    public void sort() {

        for (int x = this.persons.length - 1; x >= 1; x--) {

            for (int y = 0; y < x; y++) {

                String name1 = this.persons[y].getName();
                String name2 = this.persons[y + 1].getName();

                if (compare(name1, name2) > 0) {

                    this.persons = swap(this.persons, y, y + 1);
                    this.counter++;

                }

                for (int i = this.persons.length - 1; i >= 1; i--) {

                    for (int j = 0; j < i; j++) {

                        if (this.persons[j].getAge() < this.persons[j + 1].getAge()) {

                            this.persons = swap(this.persons, j, j + 1);
                            this.counter++;

                        }

                        for (int k = this.persons.length - 1; k >= 1; k--) {

                            for (int l = 0; l < k; l++) {

                                if (this.persons[l].getSex().getSexFlag() < this.persons[l + 1].getSex().getSexFlag()) {

                                    this.persons = swap(this.persons, l, l + 1);
                                    this.counter++;

                                }

                            }

                        }

                    }

                }


            }

        }

        for (int a = 0; a < this.persons.length - 1; a++) {

            try {

                if(this.persons[a].getName().equals(this.persons[a + 1].getName()) &&
                        this.persons[a].getAge() == this.persons[a + 1].getAge() &&
                        this.persons[a].getSex().getSexFlag() == this.persons[a + 1].getSex().getSexFlag()) {

                    throw new TheSameNameAndAgeMyException();

                }

            } catch(TheSameNameAndAgeMyException e) {

                System.out.println("ATTENTION!\n" +
                        "В массиве имеются повторяющиеся объекты!\n");

            }

        }

    }

}
