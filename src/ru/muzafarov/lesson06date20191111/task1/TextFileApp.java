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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TextFileApp implements Cloneable {

    private static String fileResource = "src/ru/muzafarov/lesson06date20191111/resources/fileResource.txt";
    private static String fileDestination = "src/ru/muzafarov/lesson06date20191111/resources/fileDestination.txt";
    private static List<String> words = new ArrayList<>();


    public static void main(String[] args) {

        fromFileToList(fileResource);
        sortList();
        fromListToFile(fileDestination);

    }

    // Запись содержимого файла в список
    public static void fromFileToList(String fileResource) {

        List<Integer> symbolsInteger = new ArrayList<>();
        Set<String> set = new TreeSet<>();


        try(FileInputStream fin = new FileInputStream(fileResource)) {

            String st = "jgnn flefz r,grlpem dd ab ab";

            String[] arr = st.toLowerCase().split(" ");

            for (int i = 0; i < arr.length; i++) {

                set.add(arr[i]);

            }

            /*
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

    // Сортировка списка

    /*
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

            // Для Set нужен Итератор

            for (int n = 0; n < (words.size() - 1); n++) {

                byte[] buffer = words.get(n).getBytes();
                fout.write(buffer);

                if (words.get(n).toLowerCase().equals(words.get(n + 1).toLowerCase())) {

                    n++;

                }

            }

        } catch (FileNotFoundException ex) {

            ex.printStackTrace();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
