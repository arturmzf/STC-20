/**
 * Занятие № 3 [от 01.11.2019 (Пт)]
 * Темы:
 * - Исключения.
 * - Родовые типы Java (Generics)
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson03date20191101.task1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class MathBox {

    private Number[] numbers;
    private ArrayList<Number> numbersCollection;

    public MathBox(Number[] numbers) {

        this.numbers = numbers;

        this.numbersCollection = new ArrayList<Number>(Arrays.asList(numbers));
        //Set<Number> numbers = new HashSet<Number>;


    }

    public int summator() {

        int sum = 0;

        for(int i = 0; i < this.numbersCollection.size(); i++) {

            sum += (int)this.numbersCollection.get(i).getNumber();

        }

        return sum;

    }

    public void splitter(int divisor) {

        for(int i = 0; i < this.numbersCollection.size(); i++) {


            this.numbers[i].setNumber(((int)((int)this.numbersCollection.get(i).getNumber() / divisor)));
            this.numbersCollection = new ArrayList<Number>(Arrays.asList(this.numbers));

        }

    }

    public void congruenceFinder(Integer element) {

        for(int i = 0; i < this.numbersCollection.size(); i++) {

            if(this.numbersCollection.get(i).getNumber().equals(element)) {

                this.numbersCollection.remove(i);

            }

        }

    }

    @Override
    public String toString() {

        return " ";

    }

    @Override
    public int hashCode() {

        return 0;

    }

    @Override
    public boolean equals(Object obj) {

        return false;

    }

}
