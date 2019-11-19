/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

public enum Sex {

    MAN(1, "Мужчина", 'М', "Man", 'M'),
    WOMAN(0,"Женщина", 'Ж', "Woman", 'W');

    private int sexFlag;
    private String sexRu;
    private char sexRuChar;
    private String sexEn;
    private char sexEnChar;

    public int getSexFlag() {
        return sexFlag;
    }

    public void setSexFlag(int sexFlag) {
        this.sexFlag = sexFlag;
    }

    public String getSexRu() {
        return sexRu;
    }

    public char getSexRuChar() {
        return sexRuChar;
    }

    public String getSexEn() {
        return sexEn;
    }

    public char getSexEnChar() {
        return sexEnChar;
    }

    Sex(int sexFlag, String sexRu,  char sexRuChar, String sexEn, char sexEnChar) {
        this.sexFlag = sexFlag;
        this.sexRu = sexRu;
        this.sexRuChar = sexRuChar;
        this.sexEn = sexEn;
        this.sexEnChar = sexEnChar;
    }

}
