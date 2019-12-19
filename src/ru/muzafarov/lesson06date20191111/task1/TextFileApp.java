/**
 * Занятие № 06 [от 11.11.2019 (Пн)]
 * Темы:
 * - Пакет java.io
 * - Работа с ресурсами
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson06date20191111.task1;

import java.io.*;
import java.util.*;

public class TextFileApp implements Cloneable {

    private static String fileResource = "src/ru/muzafarov/lesson06date20191111/resources/fileResource.txt";
    private static String fileDestination = "src/ru/muzafarov/lesson06date20191111/resources/fileDestination.txt";
    // private static List<String> words = new ArrayList<>(); // Устаревшее решение
    private static Set<String> setOfWords = new TreeSet<>();

    public static void main(String[] args) {
        fromFileToList(fileResource);
        // sortList(); // Устаревшее решение
        fromListToFile(fileDestination);
    }

    // Запись содержимого файла в список
    public static void fromFileToList(String fileResource) {

        //List<Integer> symbolsInteger = new ArrayList<>(); // Устаревшее решение

        try(FileInputStream fin = new FileInputStream(fileResource)) {

            int i = -1;
            String wholeFileString = "";
            while ((i = fin.read()) != -1) {
                wholeFileString += (char) i;
            }
            String[] resultWords = wholeFileString.toLowerCase().split(" ");

            for (int m = 0; m < resultWords.length; m++) {
                if (!setOfWords.add(resultWords[m])) {
                    System.out.println("WARNING: Слово уже существует в списке...");
                }
            }

            /*
            // Устаревшее решение
            int i = -1;
            while ((i = fin.read() - 1) != -1) {
                while (((char) i != ' ') || ((char) i != '\n')) {
                    symbolsInteger.add(i);
                }
                char[] symbolsArray = new char[symbolsInteger.size()];
                for (int m = 0; m < symbolsArray.length; m++) {
                    symbolsArray[m] = (char)((int) symbolsInteger.get(m));
                }
                words.add(new String(symbolsArray));
                symbolsInteger.clear();
            }
            */

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /*
    // Сортировка списка
    // Учтаревшее решение
    public static void sortList(){
        for (int x = words.size() - 1; x >= 1; x--) {
            for (int y = 0; y < x; y++) {
                if (words.get(y).compareTo(words.get(y + 1)) < 0) {
                    String tempWord = words.get(y);
                    words.set(y, words.get(y + 1));
                    words.set(y + 1, tempWord);
                }
            }
        }
    }
    */

    // Запись содержимого списка в новый файл
    public static void fromListToFile(String fileDestination){
        try(FileOutputStream fout = new FileOutputStream(fileDestination)) {
            // Для setOfWords нужен Итератор
            Iterator<String> setOfWordsIterator = setOfWords.iterator();
            while (setOfWordsIterator.hasNext()) {
                byte[] buffer = setOfWordsIterator.next().getBytes();
                fout.write(buffer);
            }

            /*
            // Устаревшее решение
            for (int n = 0; n < (words.size() - 1); n++) {
                byte[] buffer = words.get(n).getBytes();
                fout.write(buffer);
                if (words.get(n).toLowerCase().equals(words.get(n + 1).toLowerCase())) {
                    n++;
                }
            }
            */

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
