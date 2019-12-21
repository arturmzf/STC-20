/**
 * Занятие № 06 [от 11.11.2019 (Пн)]
 * Темы:
 * - Пакет java.io
 * - Работа с ресурсами
 *
 * Музафаров Артур Ринатович
 */

// НЕ ВЫПОЛНЯТЬ ЭТОТ ПУНКТ ПОКА!
// Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
// который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.

package ru.muzafarov.lesson06date20191111.task2;

import java.util.Random;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TextFilesGeneratorApp {

    private static Random rnd = new Random();
    private static String wholeText = "";

    public static void main(String[] args) {
        int y = rnd.nextInt(7);
        for (int x = 0; x < y; x++) {
            wholeText += createParagraf(rnd.nextInt(20));
        }
        System.out.println(wholeText);
        // Вывод в файл
        // Обратить внимание на перенос
    }

    // Создание абзаца
    // Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений.
    // В конце абзаца стоит разрыв строки и перенос каретки
    public static String createParagraf(int amountOfSentenses) {
        String wholeParagraf = "";
        for (int k = 0; k < amountOfSentenses; k++) {
            wholeParagraf += createSentence(rnd.nextInt(15)); // 1..15
        }
        System.out.println();
        System.out.println();
        return wholeParagraf;
    }

    // Создание предложения
    public static String createSentence(int amountOfWords) {

        String newSentence = createWord(rnd.nextInt(15), TRUE); // 1..15

        // РАНДОМНО вставляем запятую с пробелом или только пробел
        if ((rnd.nextInt(2) == 0) ? TRUE : FALSE) {
            newSentence += ", ";
        } else {
            newSentence += " ";
        }

        for (int i = 0; i < amountOfWords - 2; i++) {

            newSentence += createWord(rnd.nextInt(15), FALSE); // 1..15
            // РАНДОМНО вставляем запятую с пробелом или только пробел
            if ((rnd.nextInt(2) == 0) ? TRUE : FALSE) {
                newSentence += ", ";
            } else {
                newSentence += " ";
            }

        }

        newSentence += createWord(rnd.nextInt(15), FALSE); // 1..15

        // РАНДОМНО вставляем один из знаков
        String punctuation = ".!?";
        newSentence += punctuation.charAt(rnd.nextInt(punctuation.length()));

        return newSentence;

    }

    // Создание слова
    public static String createWord(int amountOfLetters, boolean firstWord) {

        String stUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String stLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String stBothCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String newWord = "";

        if (firstWord) {
            newWord += stUpperCase.charAt(rnd.nextInt(stUpperCase.length()));
            for (int i = 0; i < amountOfLetters - 1; i++) {
                newWord += stLowerCase.charAt(rnd.nextInt(stLowerCase.length()));
            }
        } else {
            newWord += stBothCase.charAt(rnd.nextInt(stBothCase.length()));
            for (int i = 0; i < amountOfLetters - 1; i++) {
                newWord += stLowerCase.charAt(rnd.nextInt(stLowerCase.length()));
            }
        }
        return newWord;
    }
}
