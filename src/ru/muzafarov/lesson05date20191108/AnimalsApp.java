/**
 * Занятие № 05 [от 08.11.2019 (Пт)]
 * Темы:
 * - Родовые типы Java (Generics).
 * - Collection Framework
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson05date20191108;

import java.util.*;

public class AnimalsApp {

    /*
    // Ручное заполнение
    public static Animal animal01 = new Animal(0, Type.CAT, "Барсик", new Person("Василий", 28, Sex.MAN), 4);
    public static Animal animal02 = new Animal(1, Type.DOG, "Шарик", new Person("Екатерина", 22, Sex.WOMAN), 11);
    public static Animal animal03 = new Animal(2, Type.FISH, "Золотая", new Person("Александра", 15, Sex.WOMAN), 1);
    public static Animal animal04 = new Animal(3, Type.PARROT, "Кеша", new Person("Виталий", 48, Sex.MAN), 1);
    */

    public static int animalMainId = 0;
    public static Map<Integer, Animal> animals = new TreeMap<>();

    public static void main(String[] args) {

        System.out.println("Здравствуйте!");
        System.out.println("Выберите, что Вы хотели бы сделать:");
        System.out.println("1 - Ввести в картотеку данные о новом животном;");
        System.out.println("2 - Узнать присутствие животного в картотеке по кличке;");
        System.out.println("3 - Изменить данные животного;");
        System.out.println("4 - Вывести на экран список животных.");
        System.out.println("Пожалуйста, выберите действие, введите его номер в поле ниже и нажмите клавишу ENTER:");

        Scanner scanner1 = new Scanner(System.in);
        int choose = scanner1.nextInt();
        int check0 = 0;
        while(check0 == 0) {

            switch(choose) {

                case 1:

                    System.out.println("Выберите, пожалуйста, тип животного:");
                    System.out.println("1 - Кот;");
                    System.out.println("2 - Собака;");
                    System.out.println("3 - Рыбка;");
                    System.out.println("4 - Попугай.");
                    System.out.println("Выберите тип, введите его номер в поле ниже и нажмите клавишу ENTER:");
                    Scanner scanner2 = new Scanner(System.in);
                    int animalTypeInt = scanner2.nextInt();
                    Type animalType = null;

                    int check1 = 0;
                    while(check1 == 0) {

                        switch(animalTypeInt) {

                            case 1:

                                animalType = Type.CAT;
                                check1 = 1;
                                break;

                            case 2:

                                animalType = Type.DOG;
                                check1 = 1;
                                break;

                            case 3:

                                animalType = Type.FISH;
                                check1 = 1;
                                break;

                            case 4:

                                animalType = Type.PARROT;
                                check1 = 1;
                                break;

                            default:

                                System.out.println("Вы ввели неверный символ. Повторите попытку...");

                        }

                    }

                    System.out.println("Введите кличку животного в поле ниже и нажмите клавишу ENTER:");
                    String animalName = scanner2.nextLine();

                    System.out.println("Введите вес животного в виде целого числа в поле ниже и нажмите клавишу ENTER:");
                    int animalWeight = scanner2.nextInt();

                    System.out.println("Введите имя хозяина питомца в поле ниже и нажмите клавишу ENTER:");
                    String personName = scanner2.nextLine();

                    System.out.println("Введите возраст хозяина животного в виде целого числа в поле ниже и нажмите клавишу ENTER:");
                    int personAge = scanner2.nextInt();

                    Sex personSex = null;
                    int check2 = 0;
                    while(check2 == 0) {

                        System.out.println("Введите пол хозяина животного в виде буквы \"М\" или \"Ж\" и нажмите клавишу ENTER:");
                        String personSexString = scanner2.nextLine();

                        if(personSexString.equals("М")) {

                            personSex = Sex.MAN;
                            check2 = 1;

                        } else if(personSexString.equals("Ж")) {

                            personSex = Sex.WOMAN;
                            check2 = 1;

                        } else {

                            System.out.println("Вы ввели неверный символ. Повторите попытку...");

                        }

                    }

                    addAnimal(animalType, animalName, animalWeight, personName, personAge, personSex);

                    check0 = 1;
                    break;

                case 2:

                    check0 = 1;
                    break;

                case 3:

                    System.out.println("Пожалуйста, введите ID питомца в поле ниже и нажмите ENTER:");
                    Scanner scannerAnimalId = new Scanner(System.in);
                    changeAnimalData(scannerAnimalId.nextInt());
                    check0 = 1;
                    break;

                case 4:

                    printAnimals();
                    check0 = 1;
                    break;

                default:

                    System.out.println("Вы ввели неверный символ. Повторите попытку...");

            }

        }

    }

    // Добавление питомца
    public static void addAnimal(Type type, String animalName, int animalWeight, String personName, int personAge, Sex personSex){

        int flag = 0;
        Animal animal = new Animal(animalMainId, type, animalName, new Person(personName, personAge, personSex), animalWeight);

        while(flag == 0) {

            try {

                if(animals.containsValue(animal)) {

                    throw new DuplicateAnimalExeption();

                }

                animals.put(animalMainId, animal);

                animalMainId++;

            } catch(DuplicateAnimalExeption e) {

                System.out.println("В картотеке уже существует описание данного животного. Повторите попытку!");

            } finally {

                System.out.println("Хотите продолжить добавление питомцев?");
                System.out.println("Если да - введите 1, если нет - введите 0 в поле ниже и нажмите ENTER:");
                Scanner scannerWantToAdd = new Scanner(System.in);
                int wantToAdd = scannerWantToAdd.nextInt();

                flag = (wantToAdd == 1) ? 0 : 1;

            }

        }

        /*
        // Ручное заполнение
        animals.put(animal01.getId(), animal01);
        animals.put(animal02.getId(), animal02);
        animals.put(animal03.getId(), animal03);
        animals.put(animal04.getId(), animal04);
        */

    }

    // Поиск питомца по его кличке
    public static void searchAnimal(String animalName){

        if(animals.containsValue(animalName)) {

            System.out.println("Да! Питомец (питомцы) с кличкой \"" + animalName + "\" найден(ы) в нашем каталоге!");
            System.out.println("Вот вся информация о нём (них):");
            System.out.println();

            List<Integer> animalIds = new ArrayList<>(animals.keySet());
            List<Animal> animalObjects = new ArrayList<>(animals.values());

            for(int i = 0; i < animalObjects.size(); i++) {

                if(animalObjects.get(i).getName().equals(animalName)) {

                    System.out.println("Иденцификационный номер питомца: " + animalObjects.get(i).getId() + ".");
                    System.out.println("Тип животного: " + animalObjects.get(i).getType().getTypeTitle() + ".");
                    System.out.println("Кличка: " + animalName + ".");
                    System.out.println("Вес питомца: " + animalObjects.get(i).getWeight() + ".");
                    System.out.println("Хозяин питомца: " + animalObjects.get(i).getOwner().getName() +
                            " - " + animalObjects.get(i).getOwner().getAge() + " лет (год/года)" +
                            " - " + animalObjects.get(i).getOwner().getSex().getSexTitle() + ".");
                    System.out.println();

                }

            }

            System.out.println("На этом ВСЁ! //музыка из Ералаша//");
            System.out.println();

        } else {

            System.out.println("К сожалению, в коллекции питомца с такой кличкой нет...");
            System.out.println();

        }

    }

    // Изменение данных питомца по его идентификатору
    public static void changeAnimalData(int animalId){

        if(animals.containsKey(animalId)) {

            System.out.println("Пожалуйста, введите текущий вес питомца в поле ниже и нажмите ENTER:");
            Scanner scannerChangeInformation = new Scanner(System.in);
            Animal changedAnimal = animals.get(animalId);
            changedAnimal.setWeight(scannerChangeInformation.nextInt());
            animals.put(animalId, changedAnimal);
            System.out.println("Вес питомца изменён!");

        } else {

            System.out.println("К сожалению, в коллекции питомца с таким ID нет...");
            System.out.println();

        }

    }

    // Вывод на экран списка животных в отсортированном порядке
    public static void printAnimals(){

        List<Animal> animalObjects = new ArrayList<>(animals.values());
        List<Animal> resultAnimalObjects = new ArrayList<>(animalObjects.size());

        for (int x = animalObjects.size() - 1; x >= 1; x--) {

            for (int y = 0; y < x; y++) {

                if (animalObjects.get(y).compareTo(animalObjects.get(y + 1)) > 0) {

                    resultAnimalObjects.set(y, animalObjects.get(y + 1));
                    resultAnimalObjects.set(y + 1, animalObjects.get(y));

                } else {

                    resultAnimalObjects.set(y, animalObjects.get(y));
                    resultAnimalObjects.set(y + 1, animalObjects.get(y + 1));

                }

            }

        }

        for(int i = 0; i < resultAnimalObjects.size(); i++) {

            System.out.println("Питомец: " + resultAnimalObjects.get(i).getName() +
                    " - Вес животного: " + resultAnimalObjects.get(i).getWeight() +
                    " - Хозяин: " + resultAnimalObjects.get(i).getOwner().getName() +
                    " - Возраст хозяина: " + resultAnimalObjects.get(i).getOwner().getAge() +
                    " - Пол хозяина: " + resultAnimalObjects.get(i).getOwner().getSex().getSexTitle());

        }

    }

}
