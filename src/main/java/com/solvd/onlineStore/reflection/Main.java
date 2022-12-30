package com.solvd.onlineStore.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("Fields:");
        Field[] fields = Human.class.getDeclaredFields();
        Arrays.stream(fields).forEach(f -> System.out.println(f.getName()));

        System.out.println();
        System.out.println("Methods:");
        Method[] methods = Human.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(m -> System.out.println(m.getName()));

        System.out.println();

        try {
            System.out.println("--- Call private method ---");
            Method method = Human.class.getDeclaredMethod("showInfo");
            method.setAccessible(true);
            method.invoke(new Human("Bob", new Date(2000 - 1900, 10, 10), 1));
            System.out.println();

            System.out.println("--- Get value from private fields ---");
            Human human2 = new Human("Jack", new Date(1991 - 1900, 9, 21), 2);

            Class<? extends Human> humanClass = human2.getClass();
            Field humanIdField = humanClass.getDeclaredField("id");
            Field humanNameField = humanClass.getDeclaredField("name");
            Field humanDateOfBirth = humanClass.getDeclaredField("dateOfBirth");

            humanIdField.setAccessible(true);
            humanNameField.setAccessible(true);
            humanDateOfBirth.setAccessible(true);

            long humanIdValue = humanIdField.getLong(human2);
            String humanNameValue = (String) humanNameField.get(human2);
            Date dateOfBirthValue = (Date) humanDateOfBirth.get(human2);

            System.out.println("Primitive type. Field 'id' = " + humanIdValue);
            System.out.println("Object type. Field 'name' = " + humanNameValue);
            System.out.println("Object type. Field 'dateOfBirth' = " + dateOfBirthValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException il) {
            il.printStackTrace();
        } catch (InvocationTargetException t) {
            t.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }
}
