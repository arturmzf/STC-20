/**
 * Занятие № 6 [от 11.11.2019 (Пн)]
 * Темы:
 * - Пакет java.io
 * - Работа с ресурсами
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson06date20191111.task2;

import ru.muzafarov.lesson02date20191030.task3.Sex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TextFilesGeneratorApp {

    public static void main(String[] args) {

        // Предложение
        int n1 = 15; // n1 = [1; 15] need Random!
        for (int i = 0; i < n1; i++) {


        }

        // Слово
        int n2 = 15; // n1 = [1; 15] need Random!
        for (int i = 0; i < n1; i++) {


        }

        // Абзац
        int n3 = 20; // n3 = [1; 20] need Random!
        for (int i = 0; i < n3; i++) {


        }

    }

    public static String createSentence(int amountOfWords) {

        int amountOfLetters1 = 15; // = [1; 15] need Random!
        String newSentence = createWord(amountOfLetters1, TRUE);

        for (int i = 0; i < amountOfWords - 2; i++) {

            int amountOfLetters2 = 15; // = [1; 15] need Random!
            newSentence += createWord(amountOfLetters2, FALSE);
            newSentence += " ";

        }

        int amountOfLetters3 = 15; // = [1; 15] need Random!
        newSentence += createWord(amountOfLetters1, FALSE);
        // РАНДОМ
        String punctuation = ".!?";


        return newSentence;

    }

    public static String createWord(int amountOfLetters, boolean firstWord) {

        //List<String> newWord = new ArrayList<>();
        Random rnd = new Random();
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
