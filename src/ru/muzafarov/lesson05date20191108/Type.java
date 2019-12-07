/**
 * Занятие № 5 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

public enum Type {

    CAT(1, "Кот"),
    DOG(2,"Собака"),
    FISH(3,"Рыбка"),
    PARROT(4,"Попугай");;

    private int typeFlag;
    private String typeTitle;

    public int getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(int typeFlag) {
        this.typeFlag = typeFlag;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    Type(int typeFlag, String typeTitle) {
        this.typeFlag = typeFlag;
        this.typeTitle = typeTitle;
    }

    Type(int typeFlag) {
        this.typeFlag = typeFlag;
    }

}
