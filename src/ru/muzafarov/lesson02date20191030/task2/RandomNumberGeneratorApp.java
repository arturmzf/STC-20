/**
 * Занятие № 02 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task2;

import java.util.Scanner;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class RandomNumberGeneratorApp {

    public static void main(String[] args) {

        int amountOfNumbers = 0;
        System.out.println("Please, enter the amount of numbers You would process, and press ENTER:");
        Scanner scanner = new Scanner(System.in);
        amountOfNumbers += scanner.nextInt();

        for(int i = 0; i < amountOfNumbers; i++) {

            double number = random() * 600 - 200;

            try{

                if(number < 0) {

                    throw new NegativeNumberException();

                }

                double squareRoot = sqrt(number);

                if((int)(squareRoot)*(int)(squareRoot) == (int) number) {

                    System.out.println(number);

                }

            } catch(NegativeNumberException e) {

                /*
                Oops! I did it again!
                 */

            } finally {

                /*
                Nothing...
                 */

            }

        }

        System.out.println("The End of Program Work...");

        /*
        // *** ДРУГОЙ ВАРИАНТ ***
        // *** ЗАТРАТНЫЙ ***
        int[] numbers = new int[amountOfNumbers];
        double[] results = new double[amountOfNumbers];

        for(int i = 0; i < amountOfNumbers; i++) {

            numbers[i] = (int) (random() * 600 - 200);
            results[i] = sqrt(numbers[i]);

            // DON'T FORGET TO REMOVE!!!
            System.out.println(numbers[i] + " - " + results[i]);

        }
        */

    }

}
