package com.solvd.onlineStore.refactoring;

import com.solvd.onlineStore.human.Gender;
import com.solvd.onlineStore.staff.StaffId;

import java.util.Date;
import java.util.Scanner;

public class InputService {

    private static Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }

    public static String inputText(String text) {
        try {
            System.out.println(text);
            return scanner.nextLine();
        } catch (NumberFormatException nf) {
            System.out.println("Incorrect data");
        }
        return null;
    }

    public static int inputInt(String text) {
        try {
            System.out.println(text);
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nf) {
            System.out.println("Incorrect data");
        }
        return -1;
    }

    public static double inputDouble(String text) {
        do {
            try {
                System.out.println(text);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException nf) {
                System.out.println("Incorrect value");
            }
        } while (true);
    }

    public static Date inputDate(String text) {
        System.out.println(text);
        int year = inputInt("Year");
        //add logic from 0  to 11
        int month = inputInt("Month");
        //add logic from 30
        int day = inputInt("Day");

        Date date = new Date(year - 1900, month, day);

        return date;
    }

    public static Gender inputGender(String text) {
        System.out.println(text);
        return Gender.valueOf(scanner.next().toUpperCase());
    }

    public static long inputLong(String text) {
        do {
            try {
                System.out.println(text);
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException nf) {
                System.out.println("Incorrect value");
            }
        } while (true);
    }

    public static StaffId inputStaffId(String text) {
        System.out.println(text);
        String department = inputText("Department");
        int departmentId = inputInt("Department ID");
        StaffId staffId = new StaffId(department, departmentId);
        return staffId;
    }
}
