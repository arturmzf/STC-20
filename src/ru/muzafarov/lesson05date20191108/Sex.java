/**
 * Занятие № 05 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

public enum Sex {

    MAN(1, 'М', "Мужчина"),
    WOMAN(0, 'Ж', "Женщина");

    private int sexFlagInt;
    private char sexFlagChar;
    private String sexTitle;

    public int getSexFlagInt() {
        return sexFlagInt;
    }

    public void setSexFlagInt(int sexFlagInt) {
        this.sexFlagInt = sexFlagInt;
    }

    public char getSexFlagChar() {
        return sexFlagChar;
    }

    public void setSexFlagChar(char sexFlagChar) {
        this.sexFlagChar = sexFlagChar;
    }

    public String getSexTitle() {
        return sexTitle;
    }

    public void setSexTitle(String sexTitle) {
        this.sexTitle = sexTitle;
    }

    Sex(int sexFlagInt, char sexFlagChar, String sexTitle) {
        this.sexFlagInt = sexFlagInt;
        this.sexFlagChar = sexFlagChar;
        this.sexTitle = sexTitle;
    }

}
