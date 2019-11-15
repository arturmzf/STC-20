package ru.muzafarov.lesson02date20191030.task3;

import java.util.Comparator;

public class CompareNames implements Comparator<String> {

    private String name1;
    private String name2;

    @Override
    public int compare(String name1, String name2) {

        // Непонятно... :(
        return this.name1.compareTo(this.name2);

    }

}
