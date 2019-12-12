/**
 * Занятие № 5 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

public class Animal implements Comparable<Animal> {

    private int id;
    private Type type;
    private String name;
    private Person owner;
    private int weight;

    public Animal(int id, Type type, String name, Person owner, int weight) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.owner = owner;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal animal) {

        int valueToReturn = 0;

        if (this.owner.compareTo(animal.owner) == 1) {

            valueToReturn = 1;

        } else if (this.owner.compareTo(animal.owner) == -1) {

            valueToReturn = -1;

        } else {

            if (this.name.compareTo(animal.name) == 1) {

                valueToReturn = 1;

            } else if (this.name.compareTo(animal.name) == -1) {

                valueToReturn = -1;

            } else {

                if (this.weight > animal.weight) {

                    valueToReturn = 1;

                } else if (this.weight < animal.weight) {

                    valueToReturn = -1;

                } else {

                    valueToReturn = 0;

                }


            }

        }

        return valueToReturn;

    }

}
