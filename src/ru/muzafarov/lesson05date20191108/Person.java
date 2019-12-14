/**
 * Занятие № 5 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person person) {

        int valueToReturn = 0;

        /*
        if (this.name.equals(person.name)) {



        } else {

            return this.name.compareTo(person.name);

        }
        */


        if (this.name.compareTo(person.name) == 1) {

            valueToReturn = 1;

        } else if (this.name.compareTo(person.name) == -1) {

            valueToReturn = -1;

        } else {

            if (this.age > person.age) {

                valueToReturn = 1;

            } else if (this.age < person.age) {

                valueToReturn = -1;

            } else {

                if (this.sex.getSexFlagInt() > person.sex.getSexFlagInt()) {

                    valueToReturn = 1;

                } else if (this.sex.getSexFlagInt() < person.sex.getSexFlagInt()) {

                    valueToReturn = -1;

                } else {

                    valueToReturn = 0;

                }

            }

        }

        return valueToReturn;

    }




}
