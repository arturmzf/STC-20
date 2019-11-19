/**
 * Занятие № 5 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

public enum Sex {

    MAN(1, "Мужчина"),
    WOMAN(0,"Женщина");

    private int sexFlag;
    private String sexTitle;

    public int getSexFlag() {
        return sexFlag;
    }

    public void setSexFlag(int sexFlag) {
        this.sexFlag = sexFlag;
    }

    public String getSexTitle() {
        return sexTitle;
    }

    Sex(int sexFlag, String sexTitle) {
        this.sexFlag = sexFlag;
        this.sexTitle = sexTitle;
    }

}
