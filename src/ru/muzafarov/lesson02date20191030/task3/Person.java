/**
 * Занятие № 02 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

public class Person implements Cloneable {

    private String name;
    private byte age;
    private Sex sex;

    public Person(String name, byte age, Sex sex) {
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    // Клонирование объекта Person
    public Person clone(){

        Person newPerson = new Person(this.getName(), this.getAge(), this.getSex());
        return newPerson;

    }
}
