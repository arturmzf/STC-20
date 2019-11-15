/**
 * Занятие № 2 [от 30.10.2019 (Ср)]
 * Темы:
 * - Операторы и структура кода.
 * - Исключения
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson02date20191030.task3;

public class BubleSorting implements Sorting {

    public Person[] persons;

    public BubleSorting(Person[] persons){

        this.persons = persons;

    }

    public void sort() {

        for(int i = this.persons.length - 1; i >= 1; i--){

            for(int j = 0; j < i; j++){

                if(this.persons[j].getAge() < this.persons[j + 1].getAge()) {

                    Person personTemp1 = this.persons[j].clone();
                    Person personTemp2 = this.persons[j + 1].clone();
                    this.persons[j] = personTemp2;
                    this.persons[j + 1] = personTemp1;

                    for(int k = this.persons.length - 1; k >= 1; k--){

                        for(int l = 0; l < k; l++){

                            if(this.persons[l].getSex().getSexFlag() < this.persons[l + 1].getSex().getSexFlag()) {

                                Person personTemp3 = this.persons[l].clone();
                                Person personTemp4 = this.persons[l + 1].clone();
                                this.persons[l] = personTemp4;
                                this.persons[l + 1] = personTemp3;

                            }

                        }

                    }

                    /*
                    for(int k = persons.length - 1; k >= 1; k--){

                        for(int l = 0; l < k; l++){

                            if(persons[l].getSex().getSexFlag() < persons[l + 1].getSex().getSexFlag()) {



                            }

                        }

                    }
                    */

                }

            }

        }

        for(int m = 0; m < this.persons.length; m++) {

            System.out.println(this.persons[m].getAge() + " - " + this.persons[m].getName());

        }

    }
}






         /*for(int i = 0; i < persons.length; i++) {


if(persons[i].getSex().equals())
                //Men


            if(persons[i].getSex().equals())
                //Women*//*


        }

    }




}
*/
