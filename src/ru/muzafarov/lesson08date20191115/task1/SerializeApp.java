/**
 * Занятие № 08 [от 15.11.2019 (Пт)]
 * Темы:
 * - Механизмы отражения
 * - Механизмы проксирования
 *
 * Музафаров Артур Ринатович
 */

package ru.muzafarov.lesson08date20191115.task1;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class SerializeApp {

    private Object object;
    private static String filePath = "src/ru/muzafarov/lesson08date20191113/resources/file.txt";

    public static void main(String[] args) {
        SerializedObject serializedObject = new SerializedObject();
        serializedObject.setA(17);
    }

    public static void serialize(Object object, String file) {
        Class objectClass = object.getClass();
        Field[] objectFields = objectClass.getDeclaredFields();
        Method[] objectMethods = objectClass.getDeclaredMethods();

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true))){

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
    public static void serialize(Object object, String file) {
        Class objectClass = object.getClass();
        Field[] objectFields = objectClass.getDeclaredFields();
        Method[] objectMethods = objectClass.getDeclaredMethods();

        try(ObjectOutput objectOutputStream = new ObjectOutput(new FileWriter(file, true))){
                //FileWriter fileWriter = new FileWriter(file, true)) {

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    */

    public static Object deSerialize(String file) {

        return object;
    }

}
