/**
 * Занятие № 3 [от 01.11.2019 (Пт)]
 * Темы:
 * - Исключения.
 * - Родовые типы Java (Generics)
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson03date20191101.task1;


import java.util.*;
import java.util.ArrayList;

public class MathBox {

    private Number[] numbers;

    private List<Number> numbersCollection;

    public MathBox(Number[] numbers) {

        this.numbers = numbers;

        this.numbersCollection = new ArrayList<Number>(Arrays.asList(numbers));

    }

    public double summator() {

        double sum = 0;

        for(int i = 0; i < numbersCollection.size(); i++) {

            sum += numbersCollection.get(i).doubleValue();

        }

        return sum;

    }

    public List<Number> splitter(int divisor) {


        //double
        // for
        List<Number> numbersCollection2 = new ArrayList<>();

        Iterator itrt = numbersCollection.iterator();

        while(itrt.hasNext()) {

            numbersCollection2.add(itrt.next().intValue() / divisor);

        }

        return numbersCollection2;

    }

    public List<Number> congruenceFinder(Integer element) {


        List<Number> numbersCollection2 = new ArrayList<Number>();

        Iterator itrt = numbersCollection.iterator();

        while(itrt.hasNext()) {

            if(element.intValue() != itrt.intValue()) {

                numbersCollection2.add(itrt.next().intValue());

            }

        }

        return numbersCollection2;

    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numbers=" + Arrays.toString(numbers) +
                ", numbersCollection=" + numbersCollection +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Arrays.equals(numbers, mathBox.numbers) &&
                Objects.equals(numbersCollection, mathBox.numbersCollection);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numbersCollection);
        result = 31 * result + Arrays.hashCode(numbers);
        return result;
    }

}
