/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

import java.util.Comparator;

public class InsertionSorting implements Sorting, Comparator<String> {

    private Person[] persons;
    private int counter = 0;

    public InsertionSorting(Person[] persons){

        this.persons = persons;

    }

    @Override
    public int compare(String title1, String title2) {

        return title1.compareTo(title2);

    }

    public void arrayPrinting(String message) {

        System.out.println("==============================");
        System.out.println("Работа сортировки методом вставки");
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

        for (int x = 1; x < this.persons.length; x++) {

            Person personTemp = this.persons[x].clone();

            int y = x;

            while((y > 0) && (this.persons[y - 1].getSex().getSexFlag() < personTemp.getSex().getSexFlag())) {

                this.persons[y] = this.persons[y - 1].clone();
                --y;

                this.counter++;
            }

            while((y > 0) && this.persons[y - 1].getAge() < personTemp.getAge() &&
                    this.persons[y - 1].getSex().getSexFlag() == personTemp.getSex().getSexFlag()) {

                this.persons[y] = this.persons[y - 1].clone();
                --y;

                this.counter++;

            }

            while((y > 0) && (compare(this.persons[y - 1].getName(), personTemp.getName()) > 0) &&
                    this.persons[y - 1].getAge() == personTemp.getAge() &&
                    this.persons[y - 1].getSex().getSexFlag() == personTemp.getSex().getSexFlag()) {

                this.persons[y] = this.persons[y - 1].clone();
                --y;

                this.counter++;
            }


                persons[y] = personTemp;

        }

        for (int q = 0; q < this.persons.length - 1; q++) {

            try {

                if(this.persons[q].getName().equals(this.persons[q + 1].getName()) &&
                        this.persons[q].getAge() == this.persons[q + 1].getAge() &&
                        this.persons[q].getSex().getSexFlag() == this.persons[q + 1].getSex().getSexFlag()) {

                    throw new TheSameNameAndAgeMyException();

                }

            } catch(TheSameNameAndAgeMyException e) {

                System.out.println("ATTENTION!\n" +
                        "В массиве имеются повторяющиеся объекты!\n");

            }

        }

    }

}
